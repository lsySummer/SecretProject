package nju.financecity_android.controller.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import nju.financecity_android.R;

/**
 * Created by coral on 16-8-26.
 */
public class Investment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_investment, container, false);
    }

    private void initComponents() {
        // 初始化投资产品列表
        listInvstProducts = (ListView) findViewById(R.id.listInvstProducts);

    }

    private View findViewById(int resId) {
        return thisView.findViewById(resId);
    }

    private View thisView;
    private ListView listInvstProducts;
}
