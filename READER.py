import os

def reader(file):
    try:
        with open(file) as f:
            print(f.read())
    except Exception as e:
        print("Error Occured : " + str(e))
    finally:
        print("program terminated successfully")


def main():
    reader(input("Enter full path of file :"))


if __name__ == '__main__':
    main()
