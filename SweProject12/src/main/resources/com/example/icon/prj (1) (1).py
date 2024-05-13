#!/usr/bin/env python
# coding: utf-8

# In[1]:


class Request:
    def __init__(self, id, request_type):
        # Initialize the Request object with an ID and request type
        self.id = id
        self.request_type = request_type

# Create an empty list to store requests
requests = []
class Student:
    def __init__(self, id, name, gender, dob, department, mobile, email):
        # Initialize the Student object with various attributes
        self.id = id
        self.name = name
        self.gender = gender
        self.dob = dob
        self.department = department
        self.mobile = mobile
        self.email = email

# Create an empty list to store student objects
students = []

class MaintenanceRequest:
    def __init__(self, id, description, status, request_date, preferred_time):
        # Initialize the MaintenanceRequest object with various attributes
        self.id = id
        self.description = description
        self.status = status
        self.request_date = request_date
        self.preferred_time = preferred_time

# Create an empty list to store maintenance request objects
maintenance_requests = []

def load_data():
    try:
        with open('students.txt', 'r') as f:
            for line in f:
                id, name, gender, dob, department, mobile, email = line.strip().split('|')
                students.append(Student(id, name, gender, dob, department, mobile, email))
    except FileNotFoundError:
        pass  # Skip loading if file is not found

    try:
        with open('maintenance_requests.txt', 'r') as f:
            for line in f:
                values = line.strip().split('|')
                if len(values) == 5:
                    id, description, status, request_date, preferred_time = values
                    maintenance_requests.append(MaintenanceRequest(id, description, status, request_date, preferred_time))
                else:
                    print(f"Skipping line due to incorrect format: {line}")
    except FileNotFoundError:
        pass  # Skip loading if file is not found

def save_data():
    with open('students.txt', 'w') as f:
        for student in students:
            f.write(f"{student.id}|{student.name}|{student.gender}|{student.dob}|{student.department}|{student.mobile}|{student.email}\n")

    with open('maintenance_requests.txt', 'w') as f:
        for request in maintenance_requests:
            f.write(f"{request.id}|{request.description}|{request.status}|{request.request_date}|{request.preferred_time}\n")

def display_menu():
    print("\nStudent Housing Management System (SHMS)")
    print("------------------------------------------------------------------------")

    # Print menu options
    print("1. Add new student information")
    print("2. Display all student information")
    print("3. Add maintenance requests")
    print("4. Display all maintenance requests")
    print("5. Display information about specific students or maintenance requests")
    print("6. Update and Delete student information or maintenance requests")
    print("7. Save specific data in new files")
    print("8. Exit")

    print("------------------------------------------------------------------------")
def add_student():
    print("\nAdding a new student...")

    # Input and validation for student ID
    while True:
        id = input("Enter ID (must be 9 digits): ")
        if len(id) == 9:
            break
        else:
            print("Invalid input. Please enter a 9-digit ID number")

    # Check if student ID already exists
    for student in students:
        if student.id == id:
            print("Error: Student ID already exists.")
            return

    # Input and validation for student name
    while True:
        name = input("Enter student name: ")
        if name.replace(" ", "").isalpha():
            break
        else:
            print("Invalid input. Please enter only letters.")

    # Input and validation for student gender
    while True:
        gender = input("Enter student gender (male or female): ")
        if gender.lower() in ['male', 'female']:
            break
        else:
            print("Invalid input. Please enter 'male' or 'female'.")

    # Input and validation for student date of birth
    while True:
        dob = input("Enter student date of birth (format: yyyy/mm/dd): ")
        if len(dob) == 10 and dob[4] == '/' and dob[7] == '/' and dob[:4].isdigit() and dob[5:7].isdigit() and dob[8:].isdigit():
            break
        else:
            print("Invalid date. Please enter in the format yyyy/mm/dd.")

    department = input("Enter student department: ")

    # Input and validation for student mobile number
    while True:
        mobile = input("Enter student mobile number (must be 10 digits and start with 05): ")
        if len(mobile) == 10 and mobile.startswith('05'):
            break
        else:
            print("Invalid input. Please enter a 10-digit number that starts with 05.")

    # Input and validation for student email address
    while True:
        email = input("Enter student email address (must be in the format s(ID-number)@kfupm.edu.sa): ")
        if email.endswith('@kfupm.edu.sa') and len(email) == 23:
            break
        else:
            print("Invalid input. Please enter an email in the format s(ID-number)@kfupm.edu.sa")

    # Create a new Student object and add it to the students list
    students.append(Student(id, name, gender, dob, department, mobile, email))

    # Save the updated data
    save_data()

    print("\nStudent added successfully!")

def display_all_students():
    if not students:
        # If there are no students in the list, print a message indicating so
        print("\nNo students")
    else:
        # Print table headers
        print("\n-------------------------------------------------------------------------------------------------------------------")
        print("{:<12} {:<20} {:<10} {:<12} {:<15} {:<12} {:<20}".format("ID", "Name", "Gender", "DOB", "Department", "Mobile", "Email"))
        print("-------------------------------------------------------------------------------------------------------------------")
        
        # Iterate over each student and print their information in a formatted manner
        for student in students:
            print("{:<12} {:<20} {:<10} {:<12} {:<15} {:<12} {:<20}".format(student.id, student.name, student.gender, student.dob, student.department, student.mobile, student.email))
        
        # Print a horizontal line to separate the table from the rest of the output
        print("-------------------------------------------------------------------------------------------------------------------")         
            
def add_maintenance_request():
    id = input("Enter student ID: ")
    for student in students:
        if student.id == id:
            # Input and validation for maintenance request description
            while True:
                description = input("Enter maintenance request description: ")
                if description.replace(" ", "").isalpha():
                    break
                else:
                    print("Invalid input. Please enter only letters.")

            # Input and validation for maintenance request status
            while True:
                status = input("Enter maintenance request status: ")
                if status.replace(" ", "").isalpha():
                    break
                else:
                    print("Invalid input. Please enter only letters.")

            # Input and validation for request date
            while True:
                request_date = input("Enter request date (format: yyyy/mm/dd): ")
                if len(request_date) == 10 and request_date[4] == '/' and request_date[7] == '/' and request_date[:4].isdigit() and request_date[5:7].isdigit() and request_date[8:].isdigit():
                    break
                else:
                    print("Invalid date. Please enter in the format yyyy/mm/dd.")

            # Input and validation for preferred time
            while True:
                preferred_time = input("Enter preferred time: ")
                if preferred_time.replace(" ", "").isalpha():
                    break
                else:
                    print("Invalid input. Please enter only letters.")

            # Create a new MaintenanceRequest object and add it to the maintenance_requests list
            maintenance_requests.append(MaintenanceRequest(str(len(maintenance_requests) + 1), description, status, request_date, preferred_time))
            
            # Save the updated data
            save_data()

            print("\nRequest added successfully!")
            return

    print("Error: Student ID not found.")
   
def display_all_requests():
    # Check if the maintenance_requests list is empty
    if not maintenance_requests:
        print("\nNo maintenance requests")
    else:
        print("\n-------------------------------------------------------------------------------------")
        print("{:<15} {:<20} {:<18} {:<14} {:<15}".format("Student ID", "Description", "Status", "Request Date", "Preferred Time"))
        print("-------------------------------------------------------------------------------------")
        # Iterate over each maintenance request in the maintenance_requests list
        for request in maintenance_requests:
            # Print the relevant information for each maintenance request
            print("{:<15} {:<20} {:<18} {:<14} {:<15}".format(request.id, request.description[:50], request.status, request.request_date, request.preferred_time))
        print("-------------------------------------------------------------------------------------")
        
def display_specific():
    print("\nDisplaying specific information...")
    id = input("Enter the id of the student you want to display: ")
    for student in students:
        if student.id == id:
            # Display general student information
            print(f"ID: {student.id}")
            print(f"Name: {student.name}")
            print(f"Gender: {student.gender}")
            print(f"Date of Birth: {student.dob}")
            print(f"Department: {student.department}")
            print(f"Mobile: {student.mobile}")
            print(f"Email: {student.email}")
            for request in maintenance_requests:
                if request.id == id:
                    # Display maintenance request information associated with the student
                    print(f"Request ID: {request.id}")
                    print(f"Description: {request.description}")
                    print(f"Status: {request.status}")
            break
    else:
        print("Error: Student not found.")
def update_delete_info():
    print("1. Update student information")
    print("2. Delete student information")
    print("3. Update maintenance request")
    print("4. Delete maintenance request")
    choice = input("Enter your choice: ")
    
    if choice == '1':
        print("\nUpdating a student...")
        id = input("Enter the id of the student you want to update: ")
        for student in students:
            if student.id == id:
                # Prompt the user to update various student attributes
                while True:
                    name = input("Enter student name: ")
                    if name.replace(" ", "").isalpha():
                        break
                    else:
                        print("Invalid input. Please enter only letters.")
                student.name = name
                
                while True:
                    gender = input("Enter student gender (male or female): ")
                    if gender.lower() in ['male', 'female']:
                        break
                    else:
                        print("Invalid input. Please enter 'male' or 'female'.")
                student.gender = gender
                
                while True:
                    dob = input("Enter student date of birth (format: yyyy/mm/dd): ")
                    if len(dob) == 10 and dob[4] == '/' and dob[7] == '/' and dob[:4].isdigit() and dob[5:7].isdigit() and dob[8:].isdigit():
                        break
                    else:
                        print("Invalid date. Please enter in the format yyyy/mm/dd.")
                student.dob = dob

                department = input("Enter student department: ")
                student.department = department    
                    
                while True:
                    mobile = input("Enter student mobile number (must be 10 digits and start with 05): ")
                    if len(mobile) == 10 and mobile.startswith('05'):
                        break
                    else:
                        print("Invalid input. Please enter a 10-digit number that starts with 05.")
                student.mobile = mobile

                while True:
                    email = input("Enter student email address (must be in the format s(ID-number)@kfupm.edu.sa): ")
                    if email.endswith('@kfupm.edu.sa') and len(email) == 23:
                        break
                    else:
                        print("Invalid input. Please enter an email in the format s(ID-number)@kfupm.edu.sa")
                student.email = email
                            
                save_data()
                print("Student updated successfully!")
                return
        print("Error: Student not found.")
        
    elif choice == '2':
        id = input("Enter student id: ")
        for i in range(len(students)):
            if students[i].id == id:
                # Delete the student from the students list
                del students[i]
                save_data()
                print("Student deleted successfully!")
                return
        print("Error: Student ID not found.")
        
    elif choice == '3':
        id = input("Enter student id: ")
        for request in maintenance_requests:
            if request.id == id:
                # Prompt the user to update the maintenance request description and status
                request.description = input("Enter new maintenance request description: ")
                request.status = input("Enter new maintenance request status: ")
                save_data()
                print("Maintenance request updated successfully!")
                return
        print("Error: Maintenance request not found.")
        
    elif choice == '4':
        id = input("Enter student id: ")
        for i in range(len(maintenance_requests)):
            if maintenance_requests[i].id == id:
                # Delete the maintenance request from the maintenance_requests list
                del maintenance_requests[i]
                save_data()
                print("Maintenance request deleted successfully!")
                return
        print("Error: Maintenance request not found.")
        
    else:
        print("Invalid choice.")

def save_specific_data():
    id = input("Enter student id: ")
    for student in students:
        if student.id == id:
            # Open a file with the student ID as the filename
            with open(f'{id}.txt', 'w') as f:
                # Write the general student information to the file
                f.write('ID, Name, Gender, DOB, Department, Mobile, Email\n')
                f.write(f'{student.id}, {student.name}, {student.gender}, {student.dob}, {student.department}, {student.mobile}, {student.email}\n')
                f.write('Student ID, Description, Status\n')
                # Write the maintenance request information associated with the student to the file
                for request in maintenance_requests:
                    if request.id == id:
                        f.write(f'{request.id}, {request.description}, {request.status}\n')
            return
    print("Error: Student ID not found.")


def main():
    load_data()
    
    while True:
        display_menu()
        choice = input("Enter the number corresponding to the action you want to perform: ")
        
        if choice.isdigit():
            choice = int(choice)
            if 1 <= choice <= 8:
                if choice == 1:
                    add_student()  # Call the function to add a new student
                elif choice == 2:
                    display_all_students()  # Call the function to display all students
                elif choice == 3:
                    add_maintenance_request()  # Call the function to add a maintenance request
                elif choice == 4:
                    display_all_requests()  # Call the function to display all maintenance requests
                elif choice == 5:
                    display_specific()  # Call the function to display specific information
                elif choice == 6:
                    update_delete_info()  # Call the function to update or delete information
                elif choice == 7:
                    save_specific_data()  # Call the function to save specific data
                else:
                    print("Exiting program.")
                    break
            else:
                print("\nInvalid choice. Please enter a number between 1 and 8.")
        else:
            print("\nInvalid input. Please enter a number.")

main()


# In[ ]:




