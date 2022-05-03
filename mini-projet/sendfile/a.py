from PIL import Image

binaryData = [[0,0,0,0,0,0,0,0,0],
            [0,1,1,1,1,1,1,0,0],
            [0,1,0,0,0,0,0,1,0],
            [0,1,0,0,0,0,1,0,0],
            [0,1,0,0,0,0,1,0,0],
            [0,1,0,0,0,0,1,0,0],
            [0,1,1,1,1,1,1,0,0],
            [0,0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0,0]]

pixelData = [255 if elem else 0 for row in binaryData for elem in row]

img = Image.new("L", (len(binaryData[0]), len(binaryData)))
img.putdata(pixelData)
img.save("image1.pbm")
