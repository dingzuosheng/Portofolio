export interface User {
  id: string;
  firstname: string;
  lastname: string;
  email: string;
  password: string;
  occupation: string;
  role: string;
  projects: Project[];
  trainings: Training[];
}

export interface Project {
  id: string;
  title: string;
  description: string;
  startDate: Date;
  endDate: Date;
  imageUrl: string;
}

export interface Training {
  id: string;
  title: string;
  date: Date;
}

export enum Role {
  ADMIN,
  USER,
}
