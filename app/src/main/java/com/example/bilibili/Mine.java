package com.example.bilibili;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mine#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mine extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView shezhi;
    private Context context;
    private PopupWindow mPopWindow;
    private PopupWindow mPopupWindow;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Mine() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mine.
     */
    // TODO: Rename and change types and number of parameters
    public static Mine newInstance(String param1, String param2) {
        Mine fragment = new Mine();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    View mine;
    View contentView;
    TextView pop_denglu;
    TextView pop_zhuxiao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mine = inflater.inflate(R.layout.fragment_mine,container,false);
        shezhi = mine.findViewById(R.id.mine_shezhi);
        contentView = inflater.inflate(R.layout.shezhi_popip, null);
        //构造popwindow
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View pop = LayoutInflater.from(mine.getContext()).inflate(R.layout.shezhi_popip, null, false);
                //1.构造一个PopupWindow，参数依次是加载的View，宽高
                final PopupWindow popWindow = new PopupWindow(contentView,
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

                //popWindow.setAnimationStyle(R.anim.);  //设置加载动画

                //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
                //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
                //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
                popWindow.setTouchable(true);
                popWindow.setTouchInterceptor(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                        // 这里如果返回true的话，touch事件将被拦截
                        // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                    }
                });
                popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效


                //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
                popWindow.showAsDropDown(shezhi, -30, 0);

            }
        });
        pop_denglu = contentView.findViewById(R.id.pop_denglu);
        pop_zhuxiao = contentView.findViewById(R.id.pop_zhuxiao);
        //跳转登录界面
        pop_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);


            }
        });
        return mine;
    }



}
