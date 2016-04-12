import { counterActions } from '../actions/Counter';

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