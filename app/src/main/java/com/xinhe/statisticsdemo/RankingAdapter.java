package com.xinhe.statisticsdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

//import static android.R.attr.id;


/**
 * Created by Administrator on 2017-05-05.
 */

public class RankingAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<RankingUser> datas;

    public RankingAdapter(Context context, List<RankingUser> datas) {
        this.context = context;
        inflater = LayoutInflater.from(context);

        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_lv_ranking, null);

            convertView.setTag(holder);
        }
        holder=(ViewHolder) convertView.getTag();

        RankingUser rUser = (RankingUser) getItem(position);

        //实例化控件
        holder.llItem = (LinearLayout) convertView.findViewById(R.id.ll_ranking_item);
        holder.rlItem = (RelativeLayout) convertView.findViewById(R.id.rl_ranking_item);

        holder.tvNum = (TextView) convertView.findViewById(R.id.tv_num);

        holder.llAvatar = (LinearLayout) convertView.findViewById(R.id.ll_avatar);
        holder.ivAvatar = (ImageView) convertView.findViewById(R.id.iv_avatar);

        holder.ivGender = (ImageView) convertView.findViewById(R.id.iv_gender);

        holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
        holder.tvValue = (TextView) convertView.findViewById(R.id.tv_value);

        switch (rUser.getNum()){
            case 1:
                holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.colorRankingFirstFont));
                holder.rlItem.setBackgroundColor(context.getResources().getColor(R.color.colorRankingFirstBack));

                holder.tvNum.setBackgroundResource(R.mipmap.icon_first);
                holder.tvNum.setText("");
                holder.llAvatar.setBackgroundColor(context.getResources().getColor(R.color.colorRankingFirstFont));

                holder.tvName.setTextColor(context.getResources().getColor(R.color.colorRankingFirstFont));
                holder.tvValue.setTextColor(context.getResources().getColor(R.color.colorRankingFirstFont));

                break;
            case 2:
                holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.colorRankingSecondFont));
                holder.rlItem.setBackgroundColor(context.getResources().getColor(R.color.colorRankingSecondBack));

                holder.tvNum.setBackgroundResource(R.mipmap.icon_second);
                holder.tvNum.setText("");
                holder.llAvatar.setBackgroundColor(context.getResources().getColor(R.color.colorRankingSecondFont));

                holder.tvName.setTextColor(context.getResources().getColor(R.color.colorRankingSecondFont));
                holder.tvValue.setTextColor(context.getResources().getColor(R.color.colorRankingSecondFont));

                break;
            case 3:
                holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.colorRankingThirdFont));
                holder.rlItem.setBackgroundColor(context.getResources().getColor(R.color.colorRankingThirdBack));

                holder.tvNum.setBackgroundResource(R.mipmap.icon_third);
                holder.tvNum.setText("");
                holder.llAvatar.setBackgroundColor(context.getResources().getColor(R.color.colorRankingThirdFont));

                holder.tvName.setTextColor(context.getResources().getColor(R.color.colorRankingThirdFont));
                holder.tvValue.setTextColor(context.getResources().getColor(R.color.colorRankingThirdFont));

                break;
            default:
                holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.colorFont));
                holder.rlItem.setBackgroundColor(context.getResources().getColor(R.color.colorBackground));

                holder.tvNum.setBackgroundColor(context.getResources().getColor(R.color.colorBackground));
                holder.tvNum.setText(rUser.getNum()+"");
                holder.llAvatar.setBackgroundColor(context.getResources().getColor(R.color.colorFont));

                holder.tvName.setTextColor(context.getResources().getColor(R.color.colorFont));
                holder.tvValue.setTextColor(context.getResources().getColor(R.color.colorFont));

                break;
        }

        if("Male".equals(rUser.getGender())){
            holder.ivGender.setBackgroundResource(R.mipmap.icon_ranking_male);
        }else{
            holder.ivGender.setBackgroundResource(R.mipmap.icon_ranking_female);
        }

        //消除listview显示乱序
        if ("".equals(holder.tvNum.getText()))
            holder.tvNum.setText("");
        else
            holder.tvNum.setText(rUser.getNum()+"");

        holder.tvName.setText(rUser.getName());

        holder.tvValue.setText(rUser.getValueHeat());

        return convertView;
    }

    class ViewHolder{
        LinearLayout llItem;
        RelativeLayout rlItem;

        TextView tvNum;

        LinearLayout llAvatar;
        ImageView ivAvatar;

        ImageView ivGender;

        TextView tvName;

        TextView tvValue;
    }
}
