import React, { Component, PropTypes } from 'react';
import Counter from './Counter.jsx';

class CounterWrapper extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    const {state, onIncrement, onDecrement, onAdd, onDelete} = this.props;
    return (
      <div>
        {state.map(function(c, i) {
          return <Counter value={c} onIncrement={() => onIncrement(i)} onDecrement={() => onDecrement(i)}/>
        })}
        {/* setting default value for new counter */}
        <button onClick={() => onAdd(0)}>Add Counter</button>
        <button onClick={onDelete}>Delete Counter</button>
      </div>
    )
  }
}

export default CounterWrapper;