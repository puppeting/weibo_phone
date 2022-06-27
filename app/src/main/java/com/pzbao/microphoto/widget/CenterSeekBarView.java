package com.pzbao.microphoto.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.ColorInt;

import com.blankj.utilcode.util.SizeUtils;

public class CenterSeekBarView extends View {

  private static final int DEFAULT_TOUCH_TARGET_SIZE = 100;

  private final Paint paint;

  private float minUnit = 0.1f;

  private int coefficient = 10;//增加的系数

  private boolean canMove = false;

  private float width = 400; // need <= getWidth()

  /**

   * progress start max

   */

          private int minProgress = 0;

  /**

   * progress end max

   */

          private int maxProgress = 100;

  /**

   * 进度条的颜色 底色 背景色

   */

          @ColorInt

  private int progressBackColor;

  /**

   * 进度条的颜色

   */

          @ColorInt

  private int progressColor;

  /**

   * current progress

   */

          private int progress = 0;

  /**

   * seekBar Thumb normal radius

   */

          private float mThumbRadius = 20;

  private float progressPosition;

  private boolean isTouchLegal = false;

  private RectF mBackRectF, mProgressRectF;

  private int mThumbDrawColor;

  private OnSeekBarChangeListener mOnSeekBarChangeListener;

  public CenterSeekBarView(Context context) {

    this(context, null);

  }

  public CenterSeekBarView(Context context, AttributeSet attrs) {

    this(context, attrs, 0);

  }

  public CenterSeekBarView(Context context, AttributeSet attrs, int defStyleAttr) {

    super(context, attrs, defStyleAttr);

    paint = new Paint();

    paint.setAntiAlias(true);

    progressBackColor = Color.parseColor("#D6E1E7");

    progressColor = Color.parseColor("#C48AFB");

    mThumbDrawColor = Color.parseColor("#4388FF");

    mBackRectF = new RectF();

    mProgressRectF = new RectF();

  }

  @Override

  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    width = getMeasuredWidth() - SizeUtils.dp2px(30);

  }

  public CenterSeekBarView setOnSeekBarChangeListener(OnSeekBarChangeListener l) {

    mOnSeekBarChangeListener = l;

    return this;

  }

  public void delProgress() {

    setProgress(progress - (int) (minUnit * coefficient));

  }

  public void addProgress() {

    setProgress(progress + (int) (minUnit * coefficient));

  }

  public void reset() {

    setProgress(minProgress);

  }

  public void setProgress(int progress) {

    if (!canMove){

      if (mOnSeekBarChangeListener != null) {

        mOnSeekBarChangeListener.onError();

      }

      return;

    }

    if (progress <= maxProgress && progress >= minProgress - maxProgress) {

      this.progress = progress;

      if (mOnSeekBarChangeListener != null) {

        mOnSeekBarChangeListener.onProgress((float) progress / coefficient);

      }

      invalidate();

    }

  }

  public void setCanMove(boolean canMove) {

    this.canMove = canMove;

  }

  @Override

  protected void onDraw(Canvas canvas) {

    super.onDraw(canvas);

//    Log.i("slack","onDraw... " + mThumbRadius);

    int centerX = getWidth() / 2; // x 是center

    int centerY = getHeight() / 2; // y 是 2/3 高度

    float startX = centerX - width / 2;

    // draw background line

    paint.setColor(progressBackColor);

    /**

             * 进度条的 高度

             */

    float progressHeight = 9;

    paint.setStrokeWidth(progressHeight);

    paint.setStyle(Paint.Style.FILL); // 实心

    mBackRectF.left = startX;

    mBackRectF.top = centerY - progressHeight;

    mBackRectF.right = startX + width;

    mBackRectF.bottom = centerY;

    /**

             * progress 字体 背景 radius

             */

    canvas.drawRoundRect(mBackRectF, 10, 10, paint);

    paint.setStyle(Paint.Style.FILL);

    paint.setColor(progressColor);

    paint.setStrokeWidth(progressHeight);

    startX = centerX;

    progressPosition = startX + (int) ((progress * (width / 2f) / (maxProgress - minProgress)));

    mProgressRectF.top = centerY - progressHeight;

    mProgressRectF.bottom = centerY;

    if (progress > 0) {

      mProgressRectF.left = startX;

      mProgressRectF.right = progressPosition;

    } else {

      mProgressRectF.left = progressPosition;

      mProgressRectF.right = startX;

    }

    canvas.drawRoundRect(mProgressRectF, 10, 10, paint);

    // draw point

    paint.setColor(mThumbDrawColor);

    canvas.drawCircle(progressPosition, centerY - progressHeight / 2, mThumbRadius, paint);

  }

  private long mLastTime;

  @Override

  public boolean onTouchEvent(MotionEvent event) {

    if (!isEnabled()) {

      return false;

    }

    switch (event.getAction()) {

      case MotionEvent.ACTION_DOWN:

        if (canMove){

          checkTouchingTarget(event);

        }else {

          if (mOnSeekBarChangeListener != null) {

            mOnSeekBarChangeListener.onError();

          }

        }

        break;

      case MotionEvent.ACTION_MOVE:

        if (isTouchLegal) {

          int tempProgress = (int) clamp((int) event.getRawX() - getLeft());

          if (tempProgress == progress) {

            break;

          }

          progress = tempProgress;

          long currentTime = System.currentTimeMillis();

          if (currentTime - mLastTime < 10) {

            // 刷新 FPS 不超过 20 fps

            break;

          }

          mLastTime = currentTime;

          invalidate(); // 在UI线程中使用 刷新View

          if (mOnSeekBarChangeListener != null) {

            mOnSeekBarChangeListener.onProgress((float) progress / coefficient);

          }

        }

        break;

      case MotionEvent.ACTION_UP:

        invalidate();

        break;

    }

    return true;

  }

  /**

   * if touch , seekBar Thumb Animation

   */

          private void checkTouchingTarget(MotionEvent event) {

    if (isTouchingTarget(event)) {

      postInvalidate();

    }

  }

  public void setMaxProgress(int maxProgress) {

    this.maxProgress = maxProgress * coefficient;

  }

  /**

   * 判断是否 touch 在 seekBar thumb 上

   *

   * @param event

   * @return

   */

          private boolean isTouchingTarget(MotionEvent event) {

    float location = progressPosition + getLeft();

    isTouchLegal = event.getRawX() > location - DEFAULT_TOUCH_TARGET_SIZE

        && event.getRawX() < location + DEFAULT_TOUCH_TARGET_SIZE;

    return isTouchLegal;

  }

  /**

   * return progress

   * -maxProgress     minProgress       maxProgress

   * \------------------------0---------------------------\

   * min         center  touch-->\     max

   * (min center touch max are positions in the screen)

   * touch progress = (touch - center) / (max - center) * maxProgress;

   */

          private float clamp(int value) {

    int centerX = getWidth() / 2;

    float min = centerX - width / 2;// the start point

    float max = centerX + width / 2;// the end point

    if (value > centerX) {

      if (value >= max) {

        return maxProgress;

      } else {

        return (int) ((maxProgress - minProgress) * (value - centerX) / (width / 2f));

      }

    } else if (value < centerX) {

      if (value <= min) {

        return -maxProgress;

      } else {

        return (int) ((maxProgress - minProgress) * (value - centerX) / (width / 2f));

      }

    } else {

      return minProgress;

    }

  }

  public interface OnSeekBarChangeListener {

    void onProgress(float progress);

    void onError();

  }

}

 
