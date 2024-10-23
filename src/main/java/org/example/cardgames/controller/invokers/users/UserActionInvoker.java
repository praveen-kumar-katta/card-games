package org.example.cardgames.controller.invokers.users;

import org.example.cardgames.model.UserAction;
import org.example.cardgames.service.actions.users.UserCommandExecutor;

public interface UserActionInvoker {

  UserCommandExecutor getAction(UserAction userAction);
}
