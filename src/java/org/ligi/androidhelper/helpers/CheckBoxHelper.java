package org.ligi.androidhelper.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckBoxHelper extends ViewHelper {

    private final CheckBox checkBox;

    public CheckBoxHelper(CheckBox checkBox) {
        super(checkBox);
        this.checkBox =checkBox;
    }

    /**
     * we will care for persistence - means on checked change there happens some save and on init set the state
     *
     * @param tag - setting is bound to tag - same tag same setting
     */
    public void careForCheckedStatePersistence(final String tag) {
        final SharedPreferences mSharedPrefs = checkBox.getContext().getSharedPreferences("ui_state", Context.MODE_WORLD_READABLE);

        checkBox.setChecked(mSharedPrefs.getBoolean(tag, checkBox.isChecked()));

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mSharedPrefs.edit().putBoolean(tag, isChecked).commit();
            }
        });
    }


}
