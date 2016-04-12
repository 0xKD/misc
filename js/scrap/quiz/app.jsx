import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import { counter, counterActions } from './reducers/Counter';
import CounterWrapper from './components/CounterWrapper.jsx';

const store = createStore(counter);
const el = document.getElementById("app");

function render() {
  ReactDOM.render(
    <CounterWrapper
      state={store.getState()}
      onIncrement={(i) => store.dispatch({type: counterActions.INCREMENT, value: i})}
      onDecrement={(i) => store.dispatch({type: counterActions.DECREMENT, value: i})}
      onAdd={(default_) => store.dispatch({type: counterActions.ADD_COUNTER, value: default_})}
      onDelete={() => store.dispatch({type: counterActions.REMOVE_COUNTER})}
    />, el
  )
}

render();
store.subscribe(render);