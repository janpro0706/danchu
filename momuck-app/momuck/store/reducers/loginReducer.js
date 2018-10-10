// @flow
import { combineReducers } from 'redux';

import { dimmerOn, dimmerOff } from './screenReducer';

const PREFIX = 'momuck/login';

// action types
const SET_ID = `${PREFIX}/setId`;
const SET_PASSWORD = `${PREFIX}/setPassword`;
const LOGIN_SUCCEED = `${PREFIX}/loginSucceed`;
const LOGIN_FAIL = `${PREFIX}/loginFail`;
const REQUEST_LOGIN = `${PREFIX}/requestLogin`;

// state flow type
type Id = string;
type Password = string;
type Request = {
    isLogined: boolean,
    isPending: boolean
};

type Login = {
    id: Id,
    password: Password,
    request: Request
};

// action flow types
type SetIdAction = {
    type: 'momuck/login/setId',
    id: string
};

type SetPasswordAction = {
    type: 'momuck/login/setPassword',
    password: string
};

type TypeAction = {
    type: string
};

// action creators
function setId(id: string) {
    return {
        type: SET_ID,
        id
    };
}

function setPassword(password: string) {
    return {
        type: SET_PASSWORD,
        password
    };
}

function loginSucceed() {
    return {
        type: LOGIN_SUCCEED
    };
}

function loginFail() {
    return {
        type: LOGIN_FAIL
    };
}

function requestLogin() {
    return async function(dispatch: any) {
        dispatch({
            type: REQUEST_LOGIN
        });
        dispatch(dimmerOn());

        return new Promise((resolve) => {
            setTimeout(function() {
                dispatch(loginSucceed());
                dispatch(dimmerOff());
                
                resolve(true);
            }, 3000);
        });
    };
}

// reducer
const initialState = {
    id: '',
    password: '',
    request: {
        isLogined: false,
        isPending: false
    }
};

function id(state: Id = '', action: SetIdAction) {
    switch (action.type) {
        case SET_ID:
            return action.id;
        default:
            return state;
    }
}

function password(state: Password = '', action: SetPasswordAction) {
    switch (action.type) {
        case SET_PASSWORD:
            return action.password;
        default:
            return state;
    }
}

function request(state: Request = initialState.request, action: TypeAction) {
    switch (action.type) {
        case LOGIN_SUCCEED:
            return {
                ...state,
                isLogined: true,
                isPending: false
            };
        case LOGIN_FAIL:
            return {
                ...state,
                isLogined: false,
                isPending: false
            };
        case REQUEST_LOGIN:
            return {
                ...state,
                isPending: true
            };
        default:
            return state;
    }
}

export {
    setId, setPassword, requestLogin
};
export default combineReducers({
    id,
    password,
    request
});