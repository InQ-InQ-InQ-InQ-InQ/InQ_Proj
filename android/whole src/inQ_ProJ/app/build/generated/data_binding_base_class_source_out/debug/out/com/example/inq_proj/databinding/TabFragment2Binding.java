// Generated by view binder compiler. Do not edit!
package com.example.inq_proj.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.inq_proj.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TabFragment2Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView idRVcard2;

  private TabFragment2Binding(@NonNull ConstraintLayout rootView, @NonNull RecyclerView idRVcard2) {
    this.rootView = rootView;
    this.idRVcard2 = idRVcard2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TabFragment2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TabFragment2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.tab_fragment2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TabFragment2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.idRVcard2;
      RecyclerView idRVcard2 = ViewBindings.findChildViewById(rootView, id);
      if (idRVcard2 == null) {
        break missingId;
      }

      return new TabFragment2Binding((ConstraintLayout) rootView, idRVcard2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
