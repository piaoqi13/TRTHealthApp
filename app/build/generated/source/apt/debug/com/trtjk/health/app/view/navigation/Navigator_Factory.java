package com.trtjk.health.app.view.navigation;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum Navigator_Factory implements Factory<Navigator> {
  INSTANCE;

  @Override
  public Navigator get() {
    return new Navigator();
  }

  public static Factory<Navigator> create() {
    return INSTANCE;
  }
}
