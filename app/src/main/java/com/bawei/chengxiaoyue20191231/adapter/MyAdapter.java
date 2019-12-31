package com.bawei.chengxiaoyue20191231.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.chengxiaoyue20191231.R;
import com.bawei.chengxiaoyue20191231.bean.UserBean;
import com.bawei.chengxiaoyue20191231.util.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2019/12/31
 * author:程小越
 * function:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    @BindView(R.id.paiming)
    TextView paiming;
    @BindView(R.id.imageview)
    ImageView imageview;
    @BindView(R.id.name)
    TextView name;
    private List<UserBean.RankingBean> list;
    private Context context;

    public MyAdapter(List<UserBean.RankingBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.paiming.setText(list.get(position).getRank() + "");
        holder.name.setText(list.get(position).getName() + "");
        GlideUtil.loadImage(list.get(position).getAvatar(), holder.imageview);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView paiming, name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
            paiming = itemView.findViewById(R.id.paiming);
            name = itemView.findViewById(R.id.name);
           //ButterKnife.bind(this);
        }
    }
}
