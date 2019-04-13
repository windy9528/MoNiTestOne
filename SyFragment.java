package monthtest.baway.com.monitestone.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import monthtest.baway.com.monitestone.R;
import monthtest.baway.com.monitestone.model.bean.NewsBean;
import monthtest.baway.com.monitestone.presenter.ShowPresenter;
import monthtest.baway.com.monitestone.view.adapter.MyAdapter;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/13 12:00
 * Description:
 */
public class SyFragment extends Fragment implements ShowPresenter.AsyncCallBack {

    public ShowPresenter showPresenter;
    private ListView listView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result = (String) msg.obj;
            Gson gson = new Gson();
            NewsBean newsBean = gson.fromJson(result, NewsBean.class);
            List<NewsBean.Item> data = newsBean.result;
            listView.setAdapter(new MyAdapter(getContext(), data));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sy, null);

        listView = view.findViewById(R.id.lv);
        showPresenter = new ShowPresenter(this);
        showPresenter.getData();

        return view;
    }

    @Override
    public void onSuccess(String result) {
        //Log.e("myData",""+data);
        Message message = new Message();
        message.obj = result;
        handler.sendMessage(message);
    }

    @Override
    public void onFailed() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "请求失败!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
