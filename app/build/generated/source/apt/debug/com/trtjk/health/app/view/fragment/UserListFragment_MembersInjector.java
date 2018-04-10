package com.trtjk.health.app.view.fragment;

import com.trtjk.health.app.view.adapter.UsersAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserListFragment_MembersInjector implements MembersInjector<UserListFragment> {
  private final Provider<UsersAdapter> usersAdapterProvider;

  public UserListFragment_MembersInjector(Provider<UsersAdapter> usersAdapterProvider) {
    assert usersAdapterProvider != null;
    this.usersAdapterProvider = usersAdapterProvider;
  }

  public static MembersInjector<UserListFragment> create(
      Provider<UsersAdapter> usersAdapterProvider) {
    return new UserListFragment_MembersInjector(usersAdapterProvider);
  }

  @Override
  public void injectMembers(UserListFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.usersAdapter = usersAdapterProvider.get();
  }

  public static void injectUsersAdapter(
      UserListFragment instance, Provider<UsersAdapter> usersAdapterProvider) {
    instance.usersAdapter = usersAdapterProvider.get();
  }
}
