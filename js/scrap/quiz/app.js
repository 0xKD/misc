import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import Counter from './components/Counter';
import counter from './reducers/Counter';

const store = createStore(counter);
const el = document.getElementById("app");

function render() {
  ReactDOM.render(
    <Counter
      value={store.getState()}
      onIncrement={() => store.dispatch({ type: 'INCREMENT' })}
      onDecrement={store.dispatch.bind(null, {"type": "DECREMENT"})}/>,
    el
  );
}
render();

store.subscribe(render);
window.store = store;