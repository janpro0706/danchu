// combine moduleVariables from all pages

import LoginVars from './login/moduleVariables';
import FoodVars from './food/moduleVariables';

let declarations = [];
let entryComponents = [];

[ LoginVars, FoodVars ].forEach((vars) => {
  declarations = declarations.concat(vars.declarations);
  entryComponents = entryComponents.concat(vars.entryComponents);
});

export { declarations, entryComponents };
