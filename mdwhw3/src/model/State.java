package model;

public class State {

	public enum StateType {
		NEW, WAITING, COMPLETED
	}

	private StateType state;
	private int id;

	public State(int id) {
		this.state = StateType.NEW;
		this.id = id;
	};

	public void confirm() {
		if (this.state == StateType.NEW) {
			this.state = StateType.WAITING;
		}
	}

	public void pay() {
		if (this.state == StateType.WAITING) {
			this.state = StateType.COMPLETED;
		}
	}

	public boolean isCompleted() {
		return this.state == StateType.COMPLETED;
	}

	public StateType getState() {
		return this.state;
	}
}
