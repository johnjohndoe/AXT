package org.ligi.androidhelper.helpers;

import android.content.Context;
import android.content.pm.ResolveInfo;

public class ResolveInfoHelper {

    public final ResolveInfo resolveInfo;

    public ResolveInfoHelper(ResolveInfo resolveInfo) {
        this.resolveInfo = resolveInfo;
    }

    public String getLabelSafely(Context context) {
        CharSequence charSequence = resolveInfo.loadLabel(context.getPackageManager());
        if (charSequence==null) {
            return "";
        }
        return charSequence.toString();
    }
}
