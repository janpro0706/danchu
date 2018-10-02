// @flow
import { dispatch } from 'redux';

// action types
const SET_USER_NAME = 'momuck/set/userName';

// action creators
function setUserName(userName) {
    return {
        type: SET_USER_NAME,
        userName
    };
}


// reducer
function rootReducer(state = {
    userName: 'janpro'   
}, action) {
    switch (action.type) {
        case SET_USER_NAME:
            return {
                ...state,
                userName: action.userName
            };
        default:
            return { ...state };
    }
}


export {
    setUserName
};

export default rootReducer;