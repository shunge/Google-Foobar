def answer(document, searchTerms):
    # your code
    # Basically iter the list to be the endpoint, and iter backward to
    # find the start point the make the substring shortest
    documentlist = document.split(" ")
    start = 0
    end = 499
    min_num = 501
    for i,current in enumerate(documentlist):
        checklist = searchTerms[:]
        if current not in searchTerms:
            continue
        else:
            checklist.remove(current)
            for j ,iter in reversed(list(enumerate(documentlist))[:i+1]):
                if iter in checklist:
                    checklist.remove(iter)
                    if not checklist:
                        if (i - j) < min_num:
                            end = i+1
                            start = j
                            min_num = i - j
                            continue
    result = ""
    for item in documentlist[start:end]:
        result = result + item + " "
    return result[:-1]