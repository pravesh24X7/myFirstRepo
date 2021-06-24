def encrypted(file):
    string = []

    try:
        with open(file) as f:
            for word in f:
                string.append(str(word))
        return string
    except:
        print("file not found ")
    else:
        print("please mention the absolute path of file")
    finally:
        print("program terminated Successfully !!")


def main():
    string = encrypted(input("Mention the name of file here :"))
    file_maker(string)


def file_maker(string):
    try:
        with open("result.prince","a") as f:
            for words in string:
                f.write(words)
    except:
        print("ERROR in COPYING FILE")
    finally:
        print("program terminate Successfully !!")


main()
