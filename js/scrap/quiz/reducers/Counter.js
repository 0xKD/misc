export const counterActions = {
  INCREMENT: "INCREMENT",
  DECREMENT: "DECREMENT",
  ADD_COUNTER: "ADD_COUNTER",
  REMOVE_COUNTER: "REMOVE_COUNTER"
};

export function counter(state = [], action) {
  switch (action.type) {
    case counterActions.INCREMENT:
      state[action.value] += 1;
      return state;
    case counterActions.DECREMENT:
      state[action.value] -= 1;
      return state;
    case counterActions.REMOVE_COUNTER:
      state.pop();
      return state;
    case counterActions.ADD_COUNTER:
      return [...state, action.value];
    default:
      return state;
  }
}