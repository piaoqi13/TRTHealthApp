package com.trtjk.health.app.view.adapter;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UsersAdapter_Factory implements Factory<UsersAdapter> {
  private final MembersInjector<UsersAdapter> usersAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public UsersAdapter_Factory(
      MembersInjector<UsersAdapter> usersAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert usersAdapterMembersInjector != null;
    this.usersAdapterMembersInjector = usersAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public UsersAdapter get() {
    return MembersInjectors.injectMembers(
        usersAdapterMembersInjector, new UsersAdapter(contextProvider.get()));
  }

  public static Factory<UsersAdapter> create(
      MembersInjector<UsersAdapter> usersAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new UsersAdapter_Factory(usersAdapterMembersInjector, contextProvider);
  }
}
