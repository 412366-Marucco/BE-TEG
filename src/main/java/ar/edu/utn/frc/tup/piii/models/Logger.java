package ar.edu.utn.frc.tup.piii.models;

import java.util.Stack;

public class Logger {
    private Stack<Action> actions;

    public Logger() {
        this.actions = new Stack<>();
    }

    public void addAction(Action action) {
        if (action == null) {
            throw new IllegalArgumentException("The action cannot be null");
        }
        actions.push(action);
    }

    //ver -> se usa clone para evitar que el código externo modifique el estado interno
    public Stack<Action> getLog() {
        return (Stack<Action>) actions.clone();
    }

    public Action getLastAction() {
        return actions.isEmpty() ? null : actions.peek();
    }

    public Action deleteAndObtainLastAction() {
        return actions.isEmpty() ? null : actions.pop();
    }

    //cantidad de acciones registradas
    public int size() {
        return actions.size();
    }
}
