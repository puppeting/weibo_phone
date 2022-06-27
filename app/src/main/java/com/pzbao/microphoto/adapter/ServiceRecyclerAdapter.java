package com.pzbao.microphoto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pzbao.microphoto.R;
import com.pzbao.microphoto.pop.ServicePop;
import com.pzbao.microphoto.pop.TsDialog;
import com.pzbao.microphoto.utils.OnItemClickLitener;

import java.util.ArrayList;
import java.util.List;

/**
 */

public class ServiceRecyclerAdapter extends RecyclerView.Adapter<ServiceRecyclerAdapter.ViewHolder>{




    private Context context;
    private List<String> list;
    private int pos=-1;
    private OnItemClickLitener mItemClickListener;



    public void setItemClickListener(OnItemClickLitener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public ServiceRecyclerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
     }

    public void setPos(int pos) {
        this.pos = pos;
        notifyDataSetChanged();
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
     }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyview_layout, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }
    private    ArrayList<String> listTask= new ArrayList<>();
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {//设
        RecyclerView recyview2 = (RecyclerView) holder.itemView.findViewById(R.id.recyview);
        LinearLayoutManager grid1 = new LinearLayoutManager(context);
         grid1.setOrientation(RecyclerView.HORIZONTAL);
         listTask.add("");
        listTask.add("");
        listTask.add("");
        listTask.add("");

        ServiceChildAdapter adapter2 = new ServiceChildAdapter(context, listTask);
        recyview2.setLayoutManager(grid1);
        recyview2.setAdapter(adapter2);
        adapter2.setItemClickListener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                TsDialog mdialog = new TsDialog(context, R.style.MyDialogStyle);
                mdialog.show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        public ViewHolder(final View view) {
            super(view);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mItemClickListener) {
                        mItemClickListener.onItemClick(view, getPosition());
                    }
                }
            });

                /* 长按回调*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (null != mItemClickListener) {
                        mItemClickListener.onItemLongClick(view, getPosition());
                    }
                    return true;
                }
            });
        }
    }

}
