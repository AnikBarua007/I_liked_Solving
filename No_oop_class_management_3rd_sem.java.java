//CSE215 Section 4 assignment
//Anik Barua 11.1.2022
//simple Class management system
//main objective->>not to use object orientation ,mainly using methods
package finalassignproject;

import java.util.Scanner;

public class FinalAssignProject {
	// two faculities
	// two courses(1,2)
	// teo sections(1,2) each
	static int[] cse215_1_enrolled = new int[39]; // sfr1_9.40(teacherid=1)
	static int cse215_1_studentcount = 0;
	static int[] cse215_2_enrolled = new int[39]; // msk1
	static int cse215_2_studentcount = 0;
	static int[] cse115_1_enrolled = new int[39]; // sfr1
	static int cse115_1_studentcount = 0;
	static int[] cse115_2_enrolled = new int[39]; // msk1
	static int cse115_2_studentcount = 0;
	static Scanner scan = new Scanner(System.in);
	static int choice;

	static public boolean element_is_at(int element, int[] array) {
		// checks if elemnet exists in the array
		for (int i = 0; i < array.length; i++) {
			if (element == array[i]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("...................................................................");
		System.out.println("......Class Management.............................................");
		System.out.println("...................................................................");
		do {
			System.out.println("Choose user type:");
			System.out.println("1.Teacher\n2.Student");
			System.out.print("choice=");
			choice = scan.nextInt();
			if (choice == 1) {

				System.out.print("Enter teacher ID:");
				int Teacher_id = scan.nextInt();
				// teacher
				do {
					System.out.println("::::::::::::::::::::::::::::::::::::::::::::::;:::::");
					System.out.println("::::::Teacher Menu::::::::::::::::::::::::::::::::::");
					System.out.println("::::::::::::::::::::::::::::::::::::::::::::::;:::::");
					System.out.println("1.Check Courses");
					System.out.println("2.Check Students");
					System.out.print("Enter Choice:");
					choice = scan.nextInt();
					if (choice == 1) {
						checkcourse(Teacher_id);

					} else if (choice == 2) {
						checkstudent(Teacher_id);
					}
					System.out.println(
							"Choose 1 to go back to Teacher menu\nChoose 0 to go back to main menu\nChoose any else number to end the program");
					System.out.print("Choice: ");
					choice = scan.nextInt();
				} while (choice == 1);
			} else if (choice == 2)// student
			{
				// sections
				// course
				System.out.print("Enter Student ID:");
				int id = scan.nextInt();
				do {
					System.out.println("::::::::::::::::::::::::::::::::::::::::::::::;:::::");
					System.out.println("::::::::Student Menu::::::::::::::::::::::::::;:::::");
					System.out.println("::::::::::::::::::::::::::::::::::::::::::::::;:::::");
					System.out.println("1.Add Course");
					System.out.println("2.Change Section");
					System.out.println("1.Remove Course");
					System.out.println("4.Enrolled Courses");
					System.out.print("Choice:");
					choice = scan.nextInt();
					while (choice > 4 || choice < 1) {
						System.out.println("Enter a valid choice->:");// error case?
						choice = scan.nextInt();
					}
					switch (choice) {
						case 1:
							addCourse(id);
							break;
						case 2:
							changeSection(id);
							break;
						case 3:
							removeCourse(id);
							break;
						case 4:
							enrolledCourse(id);
							break;
					}
					System.out.println(
							"Choose 1 to go back to student menu\nChoose 0 to go back to main menu\nChoose any else number to end the program");
					System.out.print("Choice: ");
					choice = scan.nextInt();
				} while (choice == 1);
			}
		} while (choice == 0);
		System.out.println("Porgram Ended");
		scan.close();
	}

	// ----->addcourse

	public static void addCourse(int id) {
		System.out.println("cse215(code-1)");
		System.out.println("cse115(code-2)");
		System.out.print("Enter Course Code=");
		int courseid = scan.nextInt();
		if (courseid == 1) {
			System.out.println("Course Name:CSE215");
			System.out.print("Enter Section: ");
			int section = scan.nextInt();
			// section 1
			if (section == 1) {
				System.out.println("instructor-" + "sfr1" + "\nTime: 9:40");
				if (element_is_at(id, cse215_2_enrolled) == true) {
					System.out.println("Student with given id already Enrolled in this section");

				} else if (cse215_1_studentcount == 2) {
					System.out.println("Section is full");

				} else if (element_is_at(id, cse115_1_enrolled) == true) {
					System.out.println("Class time clashes with other courses");
				} else {
					System.out.println("Press 1 to enroll,any other number to stop the process");
					int enroll = scan.nextInt();
					if (enroll == 1) {
						cse215_1_enrolled[cse215_1_studentcount] = id;
						cse215_1_studentcount++;
						System.out.println("Congratulations,You are successfully enrolled to this course");

					}
				}

			}
			// section2
			if (section == 2) {
				System.out.println("instructor-" + "msk1" + "\nTime: 11:40");

				if (element_is_at(id, cse215_1_enrolled) == true) {
					System.out.println("Student with given id already Enrolled in this section");

				} else if (cse215_2_studentcount == 2) {
					System.out.println("Section is full");

				} else if (element_is_at(id, cse115_2_enrolled) == true) {
					System.out.println("Class time clashes with other courses");
				} else {
					System.out.println("Press 1 to enroll,any other number to stop the process");
					int enroll = scan.nextInt();
					if (enroll == 1) {
						cse215_2_enrolled[cse215_1_studentcount] = id;
						cse215_2_studentcount++;
						System.out.println("Congratulations,You are successfully enrolled to this course");

					}
				}

			}
			// end section
		}
		if (courseid == 2) {
			System.out.println("Course Name:CSE215");
			System.out.print("Enter Section : ");
			int section = scan.nextInt();
			if (section == 1) {
				System.out.println("instructor-" + "sfr1" + "\nTime: 9:40");

				if (element_is_at(id, cse115_2_enrolled) == true) {
					System.out.println("Student with given id already Enrolled in this section");

				} else if (cse115_1_studentcount == 2) {
					System.out.println("Section is full");

				} else if (element_is_at(id, cse215_1_enrolled) == true) {
					System.out.println("Class time clashes with other courses");
				} else {
					System.out.println("Press 1 to enroll,any other number to stop the process");
					int enroll = scan.nextInt();
					if (enroll == 1) {
						cse115_1_enrolled[cse115_1_studentcount] = id;
						cse115_1_studentcount++;
						System.out.println("Congratulations,You are successfully enrolled to this course");

					}
				}

			}
			// section2
			if (section == 2) {
				System.out.println("instructor-" + "msk1" + "\nTime: 11:40");

				if (element_is_at(id, cse115_1_enrolled) == true) {
					System.out.println("Student with given id already Enrolled in this section");

				} else if (cse115_2_studentcount == 2) {
					System.out.println("Section is full");

				} else if (element_is_at(id, cse215_2_enrolled) == true) {
					System.out.println("Class time clashes with other courses");
				} else {
					System.out.println("Press 1 to enroll,any other number to stop the process");
					int enroll = scan.nextInt();
					if (enroll == 1) {
						cse115_2_enrolled[cse115_2_studentcount] = id;
						cse115_2_studentcount++;
						System.out.println("Congratulations,You are successfully enrolled to this course");

					}
				}
			}
			// end section
		}
	}

	// change section
	public static void changeSection(int id) {
                System.out.println("cse215(code-1)");
		System.out.println("cse115(code-2)");
		System.out.println("Enter Course code:");
		int course_id = scan.nextInt();
		if (course_id == 1) {
                    if(element_is_at(id, cse215_1_enrolled)!=true || element_is_at(id, cse215_2_enrolled)!=true){
                            System.out.println("You are not enrolled to any of the sections");
                        }
                        else{
                         System.out.println("Course Name:CSE215");
			System.out.println("Enter Section:");
			int section = scan.nextInt();
			if (section == 1) {
				System.out.println("instructor-" + "\nsfr1" + "\nTime:9:40");
				int check_enrolled = 0, index = 0;

				for (int i = 0; i < cse215_1_studentcount; i++) {
					if (cse215_1_enrolled[i] == id) {
						check_enrolled = 1;
						index = i;
						break;
					}
				}
				if (check_enrolled == 0) {
					System.out.println("You are not enrolled in this section");
				} else {
					System.out.println("You are enrolled to section 1.");
					System.out.print("Enter the section to change to:");
					int sectiontochange = scan.nextInt();
					while (sectiontochange != 2) {
						System.out.println("Enter a valid section!!!");
						sectiontochange = scan.nextInt();
					}
					if (sectiontochange == 2) {
						if (element_is_at(id, cse115_2_enrolled) == true) {
							System.out.print("Time clashes With Other sections");
						} else {
							if (cse215_2_studentcount > 2) {
								System.out.println("This seection is full.");
							} else {

								cse215_2_studentcount++;
								cse215_2_enrolled[cse215_2_studentcount] = id;
								cse215_1_enrolled[index] = 0;
								cse215_1_studentcount--;
								System.out.println("Congratulations You have Changed your section");

							}
						}
					}
				}
			} else if (section == 2) {
				System.out.println("instructor-" + "msk1" + "\nTime:11:40");
				int check_enrolled = 0, index = 0;

				for (int i = 0; i < cse215_2_studentcount; i++) {
					if (cse215_2_enrolled[i] == id) {
						check_enrolled = 1;
						index = i;
						break;
					}
				}
				if (check_enrolled == 0) {
					System.out.println("You are not enrolled in this section");
				} else {
					System.out.println("You are enrolled to section 2.");
					System.out.print("Enter the section to change to:");
					int sectiontochange = scan.nextInt();
					while (sectiontochange != 1) {
						System.out.println("Seaction not valid!\nEnter a valid section:");
						sectiontochange = scan.nextInt();
					}
					if (sectiontochange == 1) {
						if (element_is_at(id, cse215_1_enrolled) == true) {
							System.out.print("Time clashes With Other sections");
						} else {
							if (cse215_1_studentcount > 2) {
								System.out.println("This section is full.");
							} else {
								cse215_1_enrolled[cse215_1_studentcount] = id;
								cse215_1_studentcount++;
								cse215_2_enrolled[index] = 0;
								cse215_2_studentcount--;
								System.out.println("Congratulations,You have Changed your section");
							}
						}

					}

				}
			}   
                        }
		}
		if (course_id == 2) {
                        if(element_is_at(id, cse115_1_enrolled)!=true || element_is_at(id, cse115_2_enrolled)!=true){
                            System.out.println("You are not enrolled to any of the sections");
                        }
                        else{
                            System.out.println("Course Name:CSE115");
			System.out.println("Enter Section:");
			int section = scan.nextInt();
			if (section == 1) {
				System.out.println("instructor-" + "\nsfr1" + "\nTime:9:40");
				int check_enrolled = 0, index = 0;

				for (int i = 0; i < cse115_1_studentcount; i++) {
					if (cse115_1_enrolled[i] == id) {
						check_enrolled = 1;
						index = i;
						break;
					}
				}
				if (check_enrolled == 0) {
					System.out.println("You are not enrolled in this section");
				} else {
					System.out.println("You are enrolled to section 1.");
					System.out.print("Enter the section to change to:");
					int sectiontochange = scan.nextInt();
					while (sectiontochange != 2) {
						System.out.println("Enter a valid section!!!");
						sectiontochange = scan.nextInt();
					}
					if (sectiontochange == 2) {
						if (element_is_at(id, cse215_2_enrolled) == true) {
							System.out.print("Time clashes With Other sections");
						} else {
							if (cse115_2_studentcount > 2) {
								System.out.println("This seection is full.");
							} else {

								cse115_2_studentcount++;
								cse115_2_enrolled[cse115_2_studentcount] = id;
								cse115_1_enrolled[index] = 0;
								cse115_1_studentcount--;
								System.out.println("Congratulations,You have Changed your section");
							}
						}

					}

				}
			} else if (section == 2) {
				System.out.println("instructor-" + "sfr1" + "\nTime:9:40");
				int check_enrolled = 0, index = 0;

				for (int i = 0; i < cse215_2_studentcount; i++) {
					if (cse215_2_enrolled[i] == id) {
						check_enrolled = 1;
						index = i;
						break;
					}
				}
				if (check_enrolled == 0) {
					System.out.println("You are not enrolled in this section");
				} else {
					System.out.println("You are enrolled to section 2.");
					System.out.print("Enter the section to change to:");
					int sectiontochange = scan.nextInt();
					while (sectiontochange != 1) {
						System.out.println("Enter a valid section!!!");
						sectiontochange = scan.nextInt();
					}
					if (sectiontochange == 1) {
						if (element_is_at(id, cse215_1_enrolled) == true) {
							System.out.print("Time clashes With Other sections");
						} else {

							if (cse115_1_studentcount > 2) {
								System.out.println("This seection is full.");
							} else {
								cse115_1_enrolled[cse215_1_studentcount] = id;
								cse115_1_studentcount++;
								cse115_2_enrolled[index] = 0;
								cse115_2_studentcount--;
								System.out.println("Congratulations You hvae Changed your section");
							}

						}

					}

				}
			}
                        }
			
		}
	}

	// remove course method---->

	public static void removeCourse(int id) {
		System.out.println("Enter Course ID:");
		int course_id = scan.nextInt();
		if (course_id == 1) {
			System.out.println("Course Name:CSE215");
			System.out.println("Enter Section:");
			int section = scan.nextInt();
			while (section != 1 && section != 2) {
				System.out.print("Enter a valid Section:");
				section = scan.nextInt();
			}
			if (section == 1) {
				System.out.println("instructor-" + "sfr1" + "\nTime:9:40");
				int check_enrolled = 0, index = 0;

				for (int i = 0; i < cse215_1_studentcount; i++) {
					if (cse215_1_enrolled[i] == id) {
						check_enrolled = 1;
						index = i;
						break;
					}
				}
				if (check_enrolled == 0) {
					System.out.println("You are not enrolled in this section");
				} else {
					cse215_1_enrolled[index] = 0;
					cse215_1_studentcount--;
					System.out.println("You have successfully romoved your course");
				}
			}

			if (section == 2) {
				System.out.println("instructor-" + "msk1" + "\nTime:9:40");
				int check_enrolled = 0, index = 0;

				for (int i = 0; i < cse215_2_studentcount; i++) {
					if (cse215_2_enrolled[i] == id) {
						check_enrolled = 1;
						index = i;
						break;
					}
				}
				if (check_enrolled == 0) {
					System.out.println("You are not enrolled in this section");
				} else {
					cse215_2_enrolled[index] = 0;
					cse215_2_studentcount--;
					System.out.println("You have successfully romoved your course");
				}
			}
		}
		if (course_id == 2) {
			System.out.println("Course Name:CSE115");
			System.out.println("Enter Section:");
			int section = scan.nextInt();
			while (section != 1 && section != 2) {
				System.out.print("Enter a valid Section:");
				section = scan.nextInt();
			}
			if (section == 1) {
				System.out.println("instructor-" + "sfr1" + "\nTime:9:40");
				int check_enrolled = 0, index = 0;

				for (int i = 0; i < cse115_1_studentcount; i++) {
					if (cse115_1_enrolled[i] == id) {
						check_enrolled = 1;
						index = i;
						break;
					}
				}
				if (check_enrolled == 0) {
					System.out.println("You are not enrolled in this section");
				} else {
					cse115_1_enrolled[index] = 0;
					cse115_1_studentcount--;
					System.out.println("You have successfully romoved your course");
				}
			}

			if (section == 2) {
				System.out.println("instructor-" + "msk1" + "\nTime:9:40");
				int check_enrolled = 0, index = 0;

				for (int i = 0; i < cse115_2_studentcount; i++) {
					if (cse115_2_enrolled[i] == id) {
						check_enrolled = 1;
						index = i;
						break;
					}
				}
				if (check_enrolled == 0) {
					System.out.println("You are not enrolled in this section");
				} else {
					cse115_2_enrolled[index] = 0;
					cse115_2_studentcount--;
					System.out.println("You have successfully romoved your course");
				}
			}
		}
	}

	// enrolledcourse-->

	public static void enrolledCourse(int id) {
		int if_enrolled = 0;
		for (int i : cse215_1_enrolled) {
			if (i == id) {
				System.out.println("Course:CSE215,Section:1");
				if_enrolled = 1;
				break;
			}
		}
		for (int i : cse215_2_enrolled) {
			if (i == id) {
				System.out.println("Course:CSE215,Section:2");
				if_enrolled = 1;
				break;
			}
		}
		for (int i : cse115_1_enrolled) {
			if (i == id) {
				System.out.println("Course:CSE115,Section:1");
				if_enrolled = 1;
				break;
			}
		}
		for (int i : cse115_2_enrolled) {
			if (i == id) {
				System.out.println("Course:CSE115,Section:2");
				if_enrolled = 1;
				break;
			}
		}
		if (if_enrolled == 0) {
			System.out.println("You are not enrolled in any sections");
		}
	}

	////////////////////////////////////
	// teacher sections
	public static void checkcourse(int Teacher_id) {
		if (Teacher_id == 1) {
			System.out.println("Name:sfr1");
			System.out.println("Courses:cse215 Section:1");
			System.out.println("Courses:cse115 Section:1");

		} else if (Teacher_id == 2) {
			System.out.println("Name:msk1");
			System.out.println("Courses:cse215 Section:2");
			System.out.println("Courses:cse115 Section:2");
		}
	}

	public static void checkstudent(int Teacher_id) {
		if (Teacher_id == 1) {
			System.out.println("You are assigned Two courses.\n1.cse215(section 1)\n2.cse115(section 1)");
			System.out.print("Enter choice to check enrolled students in assigned courses=");
			choice = scan.nextInt();
			while (choice != 1 && choice != 2) {
				System.out.print("Enter a valid choice:");
				choice = scan.nextInt();
			}
			if (choice == 1) {
				System.out.println("Enrolled Student IDs of Section 1\n");
				for (int i : cse215_1_enrolled) {
					if (i != 0) {
						System.out.println(i);
					}
				}
				System.out.printf("\nTotal Students=%d", cse215_1_studentcount);
			} else if (choice == 2) {
				System.out.println("Enrolled Student IDs of Section 2");
				for (int i : cse115_1_enrolled) {
					if (i != 0) {
						System.out.println(i);
					}
				}
				System.out.printf("Total Students=%d\n", cse215_2_studentcount);
			}
		}
		if (Teacher_id == 2) {
			System.out.println("You are assigned Two courses.\n1.cse215(section 2)\n2.cse115(section 2)");
			System.out.print("Enter choice to check enrolled students in assigned courses=");
			choice = scan.nextInt();
			while (choice != 1 && choice != 2) {
				System.out.print("Enter a valid choice:");
				choice = scan.nextInt();
			}
			if (choice == 1) {
				System.out.println("Enrolled Student IDs of Section 1\n");
				for (int i : cse215_2_enrolled) {
					if (i != 0) {
						System.out.println(i);
					}
				}
				System.out.printf("\nTotal Students=%d", cse215_2_studentcount);
			} else if (choice == 2) {
				System.out.println("Enrolled Student IDs of Section 2");
				for (int i : cse115_2_enrolled) {
					if (i != 0) {
						System.out.println(i);
					}
				}
				System.out.printf("Total Students=%d\n", cse115_2_studentcount);
			}
		}

	}
}