# SparkStudy
spark学习

## json文件格式

每一行为一个数据源

```json
{	"name": "huyang",	"age": 23,	"gender": "male" }
{	"name": "huyang",	"age": 99,	"gender": "famale"}
{	"name": "mayan",	"age": 100,	"gender": "male"}
{	"name": "lining",	"age": 78,	"gender": "male"}
{	"name": "zhangsan",	"age": 1,	"gender": "famale"}
{	"name": "mayan",	"age": 999,	"gender": "male"}
```
## idea 调试时添加

```sbtshell
-Dspark.master=local[2] -Dspark.app.name=SparkStudy
```