# performance

This NanoId library performs a little better than [jnanoid](https://github.com/aventrix/jnanoid).

|item|jnanoid|nanoid|increase|
|:---|:---|:---|:---|
|average|833.046|1.107.014|+33%|
|std dev| 130.123| 368.018|+183%|
|max| 1.020.165 | 1.920.147|+88%|
|min| 561.960| 561.847|0%|
|total ops| 83.304.598| 110.701.360|+33%|

On above table it is possible to conclude that jnanoid runs more stable in comparison with nanoid. Overall nanoid is
faster.

For detailed overview, see [excel](./speed%20comparison.xlsx).

![graphs.png](graph%20compare.png)