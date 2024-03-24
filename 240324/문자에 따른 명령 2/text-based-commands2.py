dirs = input()
x, y = 0,0
curr_dir = 3;

dx = [1,0,-1,0]
dy = [0,-1,0,1]

for c_dir in dirs:
    if c_dir == 'L':
        curr_dir = (curr_dir +3) % 4
    elif c_dir == 'R':
        curr_dir = (curr_dir + 1) % 4
    else :
        x += dx[curr_dir]
        y += dy[curr_dir]
print(x,y)