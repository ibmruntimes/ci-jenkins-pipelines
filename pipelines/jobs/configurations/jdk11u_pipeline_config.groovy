class Config11 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac.10_15',
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--enable-dtrace=auto  --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'temurin'     : '--enable-dtrace=auto --disable-ccache'
            ],
            buildArgs           : [
                    'temurin'   : '--create-sbom',
                    'openj9'    : '--ssh'
            ]
        ],

        x64Linux  : [
            os                  : 'linux',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
            dockerImage         : 'adoptopenjdk/centos6_build_image',
            dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode          : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--disable-ccache --enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'temurin'     : '--enable-dtrace=auto --disable-ccache',
                    'corretto'    : '--enable-dtrace=auto',
                    'SapMachine'  : '--enable-dtrace=auto',
                    'dragonwell'  : '--enable-dtrace=auto --enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system --with-jvm-features=zgc',
                    'fast_startup': '--enable-dtrace=auto',
                    'bisheng'     : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server --disable-warnings-as-errors'
            ],
            buildArgs            : [
                'temurin'     : '--create-source-archive --create-sbom --enable-sbom-strace',
                'openj9'      : '--ssh'
            ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : [
                        'openj9'    : '--enable-headless-only=yes',
                        'temurin'   : '--enable-headless-only=yes --disable-ccache'
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom --enable-sbom-strace'
                ]
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : [
                        'openj9'    : '--enable-headless-only=yes',
                        'temurin'   : '--enable-headless-only=yes --disable-ccache --with-jobs=4'
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom --enable-sbom-strace'
                ]
        ],

        x64Windows: [
            os                  : 'windows',
            arch                : 'x64',
            additionalNodeLabels: [
                    openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                    temurin:    'win2022&&vs2019',
                    dragonwell: 'win2012'
            ],
            test                : 'default',
            buildArgs : [
                'temurin' : '--jvm-variant client,server --create-sbom',
                'openj9'    : '--ssh'
            ],
            configureArgs       : [
                    'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"',
                    'temurin' : '--jvm-variant client,server --create-sbom --use-adoptium-devkit vs2022_redist_14.40.33807_10.0.26100.0'
            ]
        ],

        x32Windows: [
            os                  : 'windows',
            arch                : 'x86-32',
            additionalNodeLabels: 'win2022&&vs2019',
            cleanWorkspaceAfterBuild: true,
            configureArgs       : [
                'temurin'   : '--disable-ccache'
            ],
            buildArgs : [
                    'temurin' : '--jvm-variant client,server --create-sbom --use-adoptium-devkit vs2022_redist_14.40.33807_10.0.26100.0'
            ],
            test                : 'default'
        ],

        ppc64Aix    : [
            os                  : 'aix',
            arch                : 'ppc64',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64 && sw.os.aix.7_2',
                    temurin: 'xlc13&&aix720',
            ],
            test                : 'default',
            additionalTestLabels: [
                    temurin: 'sw.os.aix.7_2'
            ],
            cleanWorkspaceAfterBuild: true,
            configureArgs       : [
                    'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
            ],
            buildArgs           : [
                    'temurin'   : '--create-sbom',
                    'openj9'    : '--ssh'
            ]
        ],

        s390xLinux    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : 'default',
            additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.s390x'
            ],
            dockerImage: 'sys-rt-docker-local/semeru/s390_rhel7_build_image',
            dockerRegistry: 'https://docker-na.artifactory.swg-devops.com/',
            dockerCredential : '7c1c2c28-650f-49e0-afd1-ca6b60479546',
            dockerNode : 'sw.tool.docker',
            configureArgs       : '--enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
            buildArgs           : [
                    'temurin'   : '--create-sbom --enable-sbom-strace',
                    'openj9'    : '--ssh'
            ]
        ],

        sparcv9Solaris    : [
                os                  : 'solaris',
                arch                : 'sparcv9',
                test                : false,
                configureArgs       : [
                        'openj9'    : '--enable-dtrace=auto',
                        'temurin'   : '--enable-dtrace=auto --disable-ccache'
                ],
                buildArgs           : [
                    'temurin'   : '--create-sbom'
            ]
        ],

        ppc64leLinux    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            test                : 'default',
            additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
            ],
            dockerImage         : 'adoptopenjdk/centos7_build_image',
            dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode         : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            configureArgs       : [
                    'temurin'     : '--enable-dtrace=auto --disable-ccache',
                    'openj9'      : '--enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
            ],
            buildArgs           : [
                    'temurin'   : '--create-sbom --enable-sbom-strace',
                    'openj9'    : '--ssh'
            ]
        ],

        arm32Linux    : [
                os                  : 'linux',
                arch                : 'arm',
                crossCompile        : 'aarch64',
                dockerImage         : 'adoptopenjdk/ubuntu1604_build_image',
                dockerArgs          : '--platform linux/arm/v7',
                test                : 'default',
                configureArgs       : [
                        'openj9'    : '--enable-dtrace=auto',
                        'temurin'   : '--enable-dtrace=auto --disable-ccache --with-jobs=4'
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        aarch64Linux    : [
            os                  : 'linux',
            arch                : 'aarch64',
            dockerImage         : 'adoptopenjdk/centos7_build_image',
            dockerNode         : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            additionalNodeLabels: [
                    openj9:  'hw.arch.aarch64 && sw.os.linux'
            ],
            test                : 'default',
            configureArgs       : [
                    'temurin' : '--enable-dtrace=auto --disable-ccache --with-jobs=4',
                    'openj9' : '--enable-dtrace=auto  --without-version-opt  --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'corretto' : '--enable-dtrace=auto',
                    'dragonwell' : '--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"',
                    'bisheng' : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
            ],
            buildArgs           : [
                    'openj9'    : '--ssh',
                    'temurin'   : '--create-sbom --enable-sbom-strace'
            ]
        ],

        riscv64Linux      :  [
            os                   : 'linux',
            arch                 : 'riscv64',
            dockerImage          : [
                    'hotspot'    : 'adoptopenjdk/ubuntu2004_build_image:linux-riscv64',
                    'openj9'     : 'adoptopenjdk/centos6_build_image',
                    'bisheng'    : 'adoptopenjdk/centos6_build_image'
            ],
            dockerArgs           : [
                    'hotspot'    : '--platform linux/riscv64'
            ],
            dockerNode         : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            crossCompile         : [
                    'hotspot'    : 'dockerhost-rise-ubuntu2204-aarch64-1',
                    'openj9'     : 'x64',
                    'bisheng'    : 'x64'
            ],
            buildArgs            : [
                    'hotspot'    : '--create-sbom',
                    'openj9'     : '--cross-compile --ssh',
                    'bisheng'    : '--cross-compile --branch risc-v'
            ],
            configureArgs        : [
                    'hotspot'    : '--enable-headless-only=yes --enable-dtrace',
                    'openj9'     : '--disable-ddr --with-cmake --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root',
                    'bisheng'    : '--openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root --with-jvm-features=shenandoahgc'
            ],
            test                 : [
                    'hotspot'    : 'default',
                    'openj9'     : false,
                    'bisheng'    : [
                        nightly : ['sanity.openjdk'],
                        weekly : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf']
                    ]
            ]
        ],
    

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9 : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac',
                        temurin: 'macos11'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        'openj9'    : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        'temurin'   : '--enable-dtrace=auto',
                        'corretto'  : '--enable-dtrace=auto',
                        'dragonwell': "--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"",
                        'bisheng'   : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
                ],
                test                : [
                        openj9 : 'default'
                ],
                buildArgs           : [
                        'openj9'    : '--ssh',
                        'temurin'   : '--create-sbom'
                ]
        ],

        riscv64Linux      :  [
                os                   : 'linux',
                arch                 : 'riscv64',
                dockerImage          : [
                        'temurin'    : 'adoptopenjdk/ubuntu2004_build_image:linux-riscv64',
                        'openj9'     : 'adoptopenjdk/centos6_build_image',
                        'bisheng'    : 'adoptopenjdk/centos6_build_image'
                ],
                dockerArgs           : [
                        'temurin'    : '--platform linux/riscv64'
                ],
                crossCompile         : [
                        'temurin'    : 'qemustatic',
                        'openj9'     : 'x64',
                        'bisheng'    : 'x64'
                ],
                buildArgs            : [
                        'temurin'    : '--create-sbom',
                        'openj9'     : '--cross-compile --ssh',
                        'bisheng'    : '--cross-compile --branch risc-v'
                ],
                configureArgs        : [
                        'temurin'    : '--enable-headless-only=yes --enable-dtrace --disable-ccache',
                        'openj9'     : '--disable-ddr --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root',
                        'bisheng'    : '--openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root --with-jvm-features=shenandoahgc'
                ],
                test                : [
                        openj9 : 'default'
                ]
        ],

        aarch64Windows: [
                os                  : 'windows',
                arch                : 'aarch64',
                dockerImage         : 'win2022_notrhel_image',
                crossCompile        : 'x64',
                additionalNodeLabels: 'win2022&&vs2022',
                test                : 'default',
                 configureArgs       : [
                        'temurin'   : '--disable-ccache'
                ],
                buildArgs       : [
                        'temurin'   : '--jvm-variant client,server --create-sbom --cross-compile --use-adoptium-devkit vs2022_redist_14.40.33807_10.0.26100.0'
                ]
        ],

        x64MacIBM    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac.10_15',
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--enable-dtrace=auto '
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        x64LinuxIBM  : [
            os                  : 'linux',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
            dockerImage         : 'adoptopenjdk/centos6_build_image',
            dockerFile: [
                    'openj9'  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode          : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'sanity.external',
                        'dev.external',
                        'dev.openjdk',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2',
                        'extended.functional.fips140_3_OpenJCEPlusFIPS',
                        'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                        'extended.jck.fips140_3_OpenJCEPlusFIPS',
                        'special.jck.fips140_3_OpenJCEPlusFIPS',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.external',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ]
            ],
            configureArgs       : [
                    'openj9'      : '--disable-ccache --enable-dtrace=auto'
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        x64WindowsIBM: [
            os                  : 'windows',
            arch                : 'x64',
            additionalNodeLabels: [
                    openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
            ],
            buildArgs : [
                    openj9 : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
            ],
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [     
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'extended.functional.fips140_3_OpenJCEPlusFIPS',
                        'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                        'extended.jck.fips140_3_OpenJCEPlusFIPS',
                        'special.jck.fips140_3_OpenJCEPlusFIPS',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system'
                    ]
            ],
            configureArgs       : [
                    'openj9'      : '--with-jdk-rc-name="IBM Semeru Runtime"'
            ],
            additionalFileNameTag: 'IBM'
        ],

        ppc64AixIBM    : [
            os                  : 'aix',
            arch                : 'ppc64',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64 && sw.os.aix.7_2'
            ],
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'extended.functional.fips140_3_OpenJCEPlusFIPS',
                        'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                        'extended.jck.fips140_3_OpenJCEPlusFIPS',
                        'special.jck.fips140_3_OpenJCEPlusFIPS',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ]
            ],
            additionalFileNameTag: 'IBM',
            cleanWorkspaceAfterBuild: true,
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        s390xLinuxIBM    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'sanity.external',
                        'dev.external',
                        'dev.openjdk',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2',
                        'extended.functional.fips140_3_OpenJCEPlusFIPS',
                        'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                        'extended.jck.fips140_3_OpenJCEPlusFIPS',
                        'special.jck.fips140_3_OpenJCEPlusFIPS',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.external',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ]
            ],
            additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.s390x'
            ],
            dockerImage: 'sys-rt-docker-local/semeru/s390_rhel7_build_image',
            dockerRegistry: 'https://docker-na.artifactory.swg-devops.com/',
            dockerCredential : '7c1c2c28-650f-49e0-afd1-ca6b60479546',
            dockerNode : 'sw.tool.docker',
            configureArgs       : '--enable-dtrace=auto',
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        ppc64leLinuxIBM    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'sanity.external',
                        'dev.external',
                        'dev.openjdk',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2',
                        'extended.functional.fips140_3_OpenJCEPlusFIPS',
                        'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                        'extended.jck.fips140_3_OpenJCEPlusFIPS',
                        'special.jck.fips140_3_OpenJCEPlusFIPS',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.external',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2',
                        'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                        'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                    ]
            ],
            additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
            ],
            dockerImage         : 'adoptopenjdk/centos7_build_image',
            dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode         : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            configureArgs       : [
                        'openj9'      : '--enable-dtrace=auto'
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        aarch64LinuxIBM    : [
            os                  : 'linux',
            arch                : 'aarch64',
            dockerImage         : 'adoptopenjdk/centos7_build_image',
            dockerNode         : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            additionalNodeLabels: [
                    openj9:  'hw.arch.aarch64 && sw.os.linux'
            ],
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'sanity.external',
                        'dev.external',
                        'dev.openjdk'                        
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.external'
                    ]
            ],
            configureArgs       : [
                    'temurin' : '--enable-dtrace=auto',
                    'openj9' : '--enable-dtrace=auto  --without-version-opt',
                    'corretto' : '--enable-dtrace=auto',
                    'dragonwell' : '--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"',
                    'bisheng' : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        aarch64MacIBM: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9 : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs'
                ],
                test                : 'default',
                additionalFileNameTag: 'IBM',
                buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
