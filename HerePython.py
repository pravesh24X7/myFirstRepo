import os

def func():
    curr_dir = os.getcwd()
    given_dir = input('Enter dir... for complete result :' )

    list_of_files = []

    try:
        if curr_dir == given_dir:
            print("We're already there User")
        else:
            os.chdir(given_dir)
    except Exception as e:
        print("Incomplete work, due to " + str(e))
    finally:
        for idx in os.listdir(os.getcwd()):
            list_of_files.append(idx)
        return list_of_files


def filter(list_of_files):
    musics = [":Musics:"]
    images = [":Images:"]
    executables = [":Executables:"]
    text = [":Text Files:"]
    pdf = [":Pdf Files:"]
    directories = [":Directory:"]
    others = [":Others Files:"]

    for item in list_of_files:
        if item[-1] == '3' and item[-2] == 'p' and item[-3] == 'm':
            musics.append(item)
        elif item[-1] == 'i' and item[-2] == 's' and item[-3] == 'm':
            executables.append(item)
        elif item[-1] == 'g' and item[-2] == 'p' and item[-3] == 'j':
            images.append(item)
        elif item[-1] == 'g' and item[-2] == 'n' and item[-3] == 'p':
            images.append(item)
        elif item[-1] == 'e' and item[-2] == 'x' and item[-3] == 'e':
            executables.append(item)
        elif item[-1] == 't' and item[-2] == 'x' and item[-3] == 't':
            text.append(item)
        elif item[-1] == 'f' and item[-2] == 'd' and item[-3] == 'p':
            pdf.append(item)
        elif '.' not in item:
            directories.append(item)
        else:
            others.append(item)

    final = [musics, directories, others, text, executables, images]
    return final


if __name__ == '__main__':
    final = filter(func())

    for list in final:
        print(list)
