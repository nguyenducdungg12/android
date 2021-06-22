// Generated by view binder compiler. Do not edit!
package com.deitel.qlsv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.deitel.qlsv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySubjectInformationBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final TextView txtSubjectCredit;

  @NonNull
  public final TextView txtSubjectPlace;

  @NonNull
  public final TextView txtSubjectTime;

  @NonNull
  public final TextView txtSubjectTitle;

  private ActivitySubjectInformationBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView imageView4, @NonNull TextView txtSubjectCredit,
      @NonNull TextView txtSubjectPlace, @NonNull TextView txtSubjectTime,
      @NonNull TextView txtSubjectTitle) {
    this.rootView = rootView;
    this.imageView4 = imageView4;
    this.txtSubjectCredit = txtSubjectCredit;
    this.txtSubjectPlace = txtSubjectPlace;
    this.txtSubjectTime = txtSubjectTime;
    this.txtSubjectTitle = txtSubjectTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySubjectInformationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySubjectInformationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_subject_information, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySubjectInformationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView4;
      ImageView imageView4 = rootView.findViewById(id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.txtSubjectCredit;
      TextView txtSubjectCredit = rootView.findViewById(id);
      if (txtSubjectCredit == null) {
        break missingId;
      }

      id = R.id.txtSubjectPlace;
      TextView txtSubjectPlace = rootView.findViewById(id);
      if (txtSubjectPlace == null) {
        break missingId;
      }

      id = R.id.txtSubjectTime;
      TextView txtSubjectTime = rootView.findViewById(id);
      if (txtSubjectTime == null) {
        break missingId;
      }

      id = R.id.txtSubjectTitle;
      TextView txtSubjectTitle = rootView.findViewById(id);
      if (txtSubjectTitle == null) {
        break missingId;
      }

      return new ActivitySubjectInformationBinding((LinearLayout) rootView, imageView4,
          txtSubjectCredit, txtSubjectPlace, txtSubjectTime, txtSubjectTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
