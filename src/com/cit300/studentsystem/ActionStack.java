// Reviewed and tested by Sasna - Stack and Queue implementation

package com.cit300.studentsystem;

import java.util.Stack;

public class ActionStack {

    private Stack<String> actions;

    public ActionStack() {
        actions = new Stack<>();
    }


    public void pushAction(String action) {
        actions.push(action);
    }


    public String popAction() {
        if (actions.isEmpty()) {
            System.out.println("No recent actions to undo.");
            return null;
        }
        return actions.pop();
    }


    public void displayActions() {
        if (actions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }
        System.out.println("---- Recent Actions (latest first) ----");
        for (int i = actions.size() - 1; i >= 0; i--) {
            System.out.println(actions.get(i));
        }
    }

    public boolean isEmpty() {
        return actions.isEmpty();
    }
}
