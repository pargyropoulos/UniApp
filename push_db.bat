git checkout --orphan database

git rm -r --cached .

git add UniDB/ -f
git commit -m "Add database files"

git push origin database --force
