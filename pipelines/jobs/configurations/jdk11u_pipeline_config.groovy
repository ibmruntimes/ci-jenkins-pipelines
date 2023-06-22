class Config11 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac.10_15',
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--enable-dtrace=auto  --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'temurin'     : '--enable-dtrace=auto'
            ],
            buildArgs           : [
                    'temurin'   : '--create-sbom'
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
            dockerNode          : 'sw.tool.docker && sw.config.uid1000',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--disable-ccache --enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'temurin'     : '--enable-dtrace=auto',
                    'corretto'    : '--enable-dtrace=auto',
                    'SapMachine'  : '--enable-dtrace=auto',
                    'dragonwell'  : '--enable-dtrace=auto --enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system --with-jvm-features=zgc',
                    'fast_startup': '--enable-dtrace=auto',
                    'bisheng'     : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server --disable-warnings-as-errors'
            ],
            buildArgs            : [
                'temurin'     : '--create-source-archive --create-sbom'
            ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        x64Windows: [
            os                  : 'windows',
            arch                : 'x64',
            additionalNodeLabels: [
                    openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                    temurin:    'win2012&&vs2019',
                    dragonwell: 'win2012'
            ],
            test                : 'default',
            buildArgs : [
                temurin : '--jvm-variant client,server --create-sbom'
            ],
            configureArgs       : [
                    'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"',
                    'temurin' : '--jvm-variant client,server'
            ]
        ],

        x32Windows: [
            os                  : 'windows',
            arch                : 'x86-32',
            additionalNodeLabels: 'win2012',
            buildArgs : [
                    temurin : '--jvm-variant client,server --create-sbom'
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
                    'temurin'   : '--create-sbom'
            ]
        ],

        s390xLinux    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : 'default',
            additionalNodeLabels: [
                    openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            configureArgs       : '--enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
            buildArgs           : [
                    'temurin'   : '--create-sbom'
            ]
        ],

        sparcv9Solaris    : [
            os                  : 'solaris',
            arch                : 'sparcv9',
            test                : false,
            configureArgs       : '--enable-dtrace=auto',
            buildArgs           : [
                    'temurin'   : '--create-sbom'
            ]
        ],

        ppc64leLinux    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            test                : 'default',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            configureArgs       : [
                    'temurin'     : '--enable-dtrace=auto',
                    'openj9'      : '--enable-dtrace=auto --enable-criu-support --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
            ],
            buildArgs           : [
                    'temurin'   : '--create-sbom'
            ]
        ],

        arm32Linux    : [
            os                  : 'linux',
            arch                : 'arm',
            test                : 'default',
            configureArgs       : '--enable-dtrace=auto',
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
                    'temurin' : '--enable-dtrace=auto',
                    'openj9' : '--enable-dtrace=auto --without-version-opt  --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'corretto' : '--enable-dtrace=auto',
                    'dragonwell' : '--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"',
                    'bisheng' : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
            ]
        ],

        riscv64Linux      :  [
            os                   : 'linux',
            arch                 : 'riscv64',
            dockerImage          : [
                    'openj9'     : 'adoptopenjdk/centos6_build_image',
                    'bisheng'    : 'adoptopenjdk/centos6_build_image'
            ],
            dockerNode         : 'sw.tool.docker && sw.config.uid1000',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            crossCompile         : [
                    'openj9'     : 'x64',
                    'bisheng'    : 'x64'
            ],
            buildArgs            : [
                    'openj9'     : '--cross-compile',
                    'bisheng'    : '--cross-compile --branch risc-v',
                    'temurin'    : '--create-sbom'
            ],
            configureArgs        : [
                    'openj9'     : '--disable-ddr --with-cmake --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root',
                    'bisheng'    : '--openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root --with-jvm-features=shenandoahgc'
            ],
            test                 : false
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
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        temurin     : '--disable-ccache'
                ],
                test                : [
                        openj9 : 'default'
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        aarch64Windows: [
                os                  : 'windows',
                arch                : 'aarch64',
                crossCompile        : 'x64',
                additionalNodeLabels: 'win2022&&vs2019',
                test                : 'default',
                buildArgs       : [
                        'temurin'   : '--jvm-variant client,server --create-sbom --cross-compile'
                ]
        ],

        x64MacIBM    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac.10_15',
            test                : [
                    nightly: [
                        'sanity.functional',
                        'extended.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'special.system'
                    ],
                    weekly : [
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'dev.jck'
                    ]
            ],
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
            dockerNode          : 'sw.tool.docker && sw.config.uid1000',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            test                : [
                    nightly: [
                        'sanity.functional',
                        'extended.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'special.system'
                    ],
                    weekly : [
                        'dev.external',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'sanity.external',
                        'sanity.functional.fips',
                        'extended.functional.fips',
                        'special.functional.fips',
                        'sanity.jck.fips',
                        'extended.jck.fips',
                        'special.jck.fips',
                        'sanity.openjdk.fips',
                        'extended.openjdk.fips',
                        'sanity.system.fips',
                        'extended.system.fips',
                        'special.system.fips',
                        'dev.jck'
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
                        'extended.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'special.system'
                    ],
                    weekly : [
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'dev.jck'
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
                        'extended.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'special.system'
                    ],
                    weekly : [
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'dev.jck'
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
                        'extended.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'special.system'
                    ],
                    weekly : [
                        'dev.external',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'sanity.external'
                    ]
            ],
            additionalNodeLabels: [
                    openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
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
                        'extended.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'special.system'
                    ],
                    weekly : [
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'sanity.external'
                    ]
            ],
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            configureArgs       : [
                        'openj9'      : '--enable-dtrace=auto --enable-criu-support'
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
                        'extended.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'special.system'
                    ],
                    weekly : [
                        'dev.external',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'sanity.external',
                        'dev.jck'
                    ]
            ],
            configureArgs       : [
                    'temurin' : '--enable-dtrace=auto',
                    'openj9' : '--enable-dtrace=auto --without-version-opt',
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
                test                : [
                    nightly: [
                        'sanity.functional',
                        'extended.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'special.system'
                    ],
                    weekly : [
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'dev.jck'
                    ]
                ],
                additionalFileNameTag: 'IBM',
                buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
