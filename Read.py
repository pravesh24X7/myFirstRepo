import os

def func(file):
    try:
        with open(file) as f:
            print(f.read())
    except Exception as e:
        print("File not Found")
    finally:
        print("Terminated Successfully !!")


def main():
    func(input("Enter file name :"))


main()
