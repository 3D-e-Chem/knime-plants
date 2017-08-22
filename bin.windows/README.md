The Linux executables have been copied out of the https://hub.docker.com/r/3dechem/silicos-it/ Docker image.
The Docker image get the source tarballs from http://silicos-it.be.s3-website-eu-west-1.amazonaws.com/software/software.html .

Contents of `src/main/resources/`:

* bin/align-it
* bin/shape-it
* bin/strip-it
* bin/filter-it
* data/ringtyp.txt, and lots of others files in ../plugin/src/main/resources/data/
* lib/plugins/svgformat.so and lots of other *.so files in lib/plugins/
* lib/libopenbabel.so.4


To make the executables relocatable the rpath has been changed with [patchelf](https://nixos.org/patchelf.html).
Commands to relocate:

```bash
for x in $(ls bin/*); do patchelf --set-rpath '$ORIGIN/.lib' $x; done
for x in $(ls lib/plugins/*); do patchelf --set-rpath '$ORIGIN/..' $x; done
```
