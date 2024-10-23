package org.example.cardgames.controller.invokers.users.impl;

import static org.example.cardgames.model.UserAction.joinroom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.cardgames.controller.invokers.users.UserActionInvoker;
import org.example.cardgames.model.UserAction;
import org.example.cardgames.service.actions.users.UserCommandExecutor;
import org.springframework.stereotype.Service;

@Service
public class UserActionInvokerImpl implements UserActionInvoker {

  private final Map<String, UserCommandExecutor> map = new HashMap<>();

  private final List<UserAction> actions = Arrays.asList(joinroom);

  public UserActionInvokerImpl() {
//    this.map = actions.stream().collect(Collectors.toMap(UserAction::name, Function.identity()));
  }

  //TODO use invokers for factory
  @Override
  public UserCommandExecutor getAction(UserAction userAction) {
//    return Objects.requireNonNull(map.get(userAction.name()));
    return null;
  }
}
