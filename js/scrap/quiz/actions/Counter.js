export const counterActions = {
  INCREMENT: "INCREMENT",
  DECREMENT: "DECREMENT",
  ADD_COUNTER: "ADD_COUNTER",
  REMOVE_COUNTER: "REMOVE_COUNTER"
};

export function increment(index) {
  return {
    type: counterActions.INCREMENT,
    value: index
  }
}

export function decrement(index) {
  return {
    type: counterActions.DECREMENT,
    value: index
  }
}

export function addCounter(value) {
  return {
    type: counterActions.ADD_COUNTER,
    value: value
  }
}

export function removeCounter() {
  return {
    type: counterActions.REMOVE_COUNTER
  }
}