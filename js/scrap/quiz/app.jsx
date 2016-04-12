import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import { counter } from './reducers/Counter';
import CounterWrapper from './components/CounterWrapper.jsx';
import * as CA from './actions/Counter';

const store = createStore(counter);
const el = document.getElementById("app");

function dispatcher(actionCreator, store) {
  return function(...args) {
    store.dispatch(actionCreator(...args));
  }
}

function render() {
  ReactDOM.render(
    <CounterWrapper
      state={store.getState()}
      onIncrement={dispatcher(CA.increment, store)}
      onDecrement={dispatcher(CA.decrement, store)}
      onAdd={dispatcher(CA.addCounter, store)}
      onDelete={dispatcher(CA.removeCounter, store)}
    />, el
  )
}

render();
store.subscribe(render);