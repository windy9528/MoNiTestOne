package monthtest.baway.com.monitestone.view.fragment;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/13 12:00
 * Description:
 */
public class WdFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("我的页面");
        return textView;
    }
}
