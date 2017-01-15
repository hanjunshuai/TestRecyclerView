package hjs.shougang.com.testrecycler;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listView;
    private List<String> list = new ArrayList<>();
    MyAdapter ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add("1");
        list.add("22");
        list.add("333");
        list.add("吃么我呢废弃物健康的年轻玩家呢请问你我娶你接口部分金额");
        list.add("55555");
        list.add("666666");
        list.add("7777777");
        list.add("88888888");
        list.add("美女千万lend看来我请你巧克力呢大家看我去年健康的挪威枪击拷贝文件全部健康大半燞不定期温家宝iuq");
        list.add("mr尅教你哦额外鸥鸟");
        list.add("呢发热今年few呢架空文+++");
        list.add("大家看我的姐啊可我呢我就课本费脑筋比我强啊还能");
        list.add("大苏打我打算但我不会觉得卡死不好哈绥喝不完");
        initView();
    }

    //设置画笔
    private Paint mPaint;

    private void initView() {

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除数据源中的数据
                list.remove(0);
                //调用刷新删除item的动画刷新
                // 一、
                //ma.notifyItemRemoved(0);
                // 二、
                ma.notifyDataSetChanged();
            }
        });

        //初始化 RecyclerView
        listView = (RecyclerView) findViewById(R.id.recycler);
        //实例化 adapter
        ma = new MyAdapter(this, list);

        //一、实例化 线性布局管理器  RecyclerView必须要有布局管理器
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //设置 水平滑动 的RecyclerView
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        //二、实例化 网格布局管理器
        GridLayoutManager glm = new GridLayoutManager(this, 1);
        //设置滑动方向
        glm.setOrientation(GridLayoutManager.HORIZONTAL);

        //三、实例化 瀑布流布局管理器
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);

        //给 RecyclerView 设置 布局管理器
        listView.setLayoutManager(sglm);

        //初始化 画笔方法
        initPaint();

        // 实例化 分割线管理器
        RecyclerView.ItemDecoration d = new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                //绘制分割线 方法
                drawLine(c, parent);
            }
        };

        //设置分割线管理器
        listView.addItemDecoration(d);

        //设置 动画管理器
        listView.setItemAnimator(new DefaultItemAnimator());

        //给 RecyclerView 设置 适配器
        listView.setAdapter(ma);
    }

    private void initPaint() {
        //实例化 画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //设置颜色
        mPaint.setColor(Color.BLUE);
         /*设置填充*/
        mPaint.setStyle(Paint.Style.FILL);
    }

    //只适用于线性布局 水平滑动
    private void drawLine(Canvas c, RecyclerView parent) {
        //拿到 开始绘制的顶点 == 分割线的顶点 == 内容的顶点
        final int top = parent.getPaddingTop();
        //拿到 开始绘制的终点
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();
        //拿到 item个数
        final int childSize = parent.getChildCount();
        //遍历item个数 给每个item画出分割线
        for (int i = 0; i < childSize; i++) {
            //拿到 此下标的布局 == item的布局
            final View child = parent.getChildAt(i);
            //拿到 布局属性
            RecyclerView.LayoutParams layoutParams =
                    (RecyclerView.LayoutParams) child.getLayoutParams();
            //拿到 布局的右坐标 加上 rightMargin == 分割线的左坐标
            final int left = child.getRight() + layoutParams.rightMargin;
            //分割线的右坐标
            final int right = left + 10;
            //绘制
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }
}


