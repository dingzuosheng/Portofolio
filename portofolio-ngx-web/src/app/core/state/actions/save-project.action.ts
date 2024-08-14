import {createAction, props} from "@ngrx/store";
import {Project} from "../../model";

export const CREATE_PROJECT = 'Create Project to User';
export const CREATE_PROJECT_SUCCESS = 'Create Project to User Sucess';
export const CREATE_PROJECT_FAIL = 'Create Project to User Fail';
export const CREATE_PROJECT_FINALIZE_SUCCESS = 'Create Project to User Finalize Success';
export const CREATE_PROJECT_FINALIZE_FAIL = 'Create Project to User Finalize Fail';

export const CreateProject = createAction(
  CREATE_PROJECT,
  props<{id: string, project: Project}>(),
);

export const CreateProjectSuccess = createAction(
  CREATE_PROJECT_SUCCESS,
  props<{id: string, project: Project}>(),
);

export const CreateProjectFail = createAction(
  CREATE_PROJECT_FAIL,
  props<{error: string}>(),
);

export const CreateProjectFinalizeSuccess = createAction(
  CREATE_PROJECT_FINALIZE_SUCCESS,
  props<{id: string, project: Project}>(),
);

export const CreateProjectFinalizeFail = createAction(
  CREATE_PROJECT_FINALIZE_FAIL,
  props<{error: string}>(),
);
