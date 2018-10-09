// @flow


// action types
const PREFIX = 'momuck/screen';

const DIMMER_ON = `${PREFIX}/dimmerOn`;
const DIMMER_OFF = `${PREFIX}/dimmerOff`;

// action flow types
type TypeAction = {
    type: string
};

// state flow types
type Dimmer = boolean;

type Screen = {
    dimmer: Dimmer
};

// action creators
function dimmerOn() {
    return {
        type: DIMMER_ON
    };
}

function dimmerOff() {
    return {
        type: DIMMER_OFF
    };
}

// reducers
const initialState = {
    dimmer: false
};

function screen(state: Screen = initialState, action: TypeAction) {
    switch (action.type) {
        case DIMMER_ON:
            return {
                ...state,
                dimmer: true
            };
        case DIMMER_OFF:
            return {
                ...state,
                dimmer: false
            };
        default:
            return state;
    }
}


export { dimmerOn, dimmerOff };
export default screen;