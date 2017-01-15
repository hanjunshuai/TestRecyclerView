package hjs.shougang.com.testrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15 0015.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    //    private int[] icons;
    private List<String> list;


    //Adapter的构造方法 用来接受上下文和数据源
    public MyAdapter(Context context, List<String> list) {
        this.context = context;
//        this.icons = icons;
        this.list = list;
    }

    // 这个方法用于创建一个ViewHolder实例，
    // 一般在这个方法内，实例化ViewHolder并将其返回。
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item, parent, false);
        //实例化ViewHolder 并 传入 view对象
        MyViewHolder mvh = new MyViewHolder(view);
        //将 ViewHolder 返回
        return mvh;
    }

    //方法是用于对RecyclerView子项的数据进行赋值的
    // 会在每个子项被滚动到屏幕内的时候执行
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
//        holder.imageView.setImageResource(icons.);
    }

    //用于告诉RecyclerView()一共有多少子项。
    @Override
    public int getItemCount() {
        return list.size();
    }

    //ViewHolder 内部类 必须继承RecyclerView.ViewHolder
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
//        ImageView imageView;

        //构造方法 view 是 item的布局view
        public MyViewHolder(View itemView) {
            super(itemView);

            // 初始化控件
            // 获取item布局内的控件对象 赋值给ViewHolder的成员变量
            textView = (TextView) itemView.findViewById(R.id.name_item);
//            imageView = (ImageView) itemView.findViewById(R.id.image_item);
        }
    }
}
