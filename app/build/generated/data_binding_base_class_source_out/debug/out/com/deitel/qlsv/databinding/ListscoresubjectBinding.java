// Generated by view binder compiler. Do not edit!
package com.deitel.qlsv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.deitel.qlsv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListscoresubjectBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView TextViewIdSubject;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView txtScoreSubject;

  @NonNull
  public final TextView txtScoreSubjectfake;

  private ListscoresubjectBinding(@NonNull LinearLayout rootView,
      @NonNull TextView TextViewIdSubject, @NonNull TextView textView2,
      @NonNull TextView txtScoreSubject, @NonNull TextView txtScoreSubjectfake) {
    this.rootView = rootView;
    this.TextViewIdSubject = TextViewIdSubject;
    this.textView2 = textView2;
    this.txtScoreSubject = txtScoreSubject;
    this.txtScoreSubjectfake = txtScoreSubjectfake;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListscoresubjectBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListscoresubjectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.listscoresubject, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListscoresubjectBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TextViewIdSubject;
      TextView TextViewIdSubject = rootView.findViewById(id);
      if (TextViewIdSubject == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = rootView.findViewById(id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.txtScoreSubject;
      TextView txtScoreSubject = rootView.findViewById(id);
      if (txtScoreSubject == null) {
        break missingId;
      }

      id = R.id.txtScoreSubjectfake;
      TextView txtScoreSubjectfake = rootView.findViewById(id);
      if (txtScoreSubjectfake == null) {
        break missingId;
      }

      return new ListscoresubjectBinding((LinearLayout) rootView, TextViewIdSubject, textView2,
          txtScoreSubject, txtScoreSubjectfake);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
