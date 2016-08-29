def answer(digest):
    # your code here
    result = []

    for i, item in enumerate(digest):
        if i is 0:
            priv = 0
        else:
            priv = result[i-1]
        a = (item^priv)
        if (a > 128):
            if (((a-128) * 129 ) ^ priv) % 256 is item:
                a = a -128
        elif (((a+128) * 129 ) ^ priv) % 256 is item:
            a = a + 128
        result.append(a)
    return  result