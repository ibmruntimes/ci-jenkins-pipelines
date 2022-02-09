class Config11 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
            test                : 'default',
            configureArgs       : [
                    "openj9"      : '--enable-dtrace=auto  --with-vendor-name="International Business Machines Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                    "hotspot"     : '--enable-dtrace=auto'
            ]
        ],

        x64MacIBM    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
            test                : 'default',
            configureArgs       : [
                    "openj9"      : '--enable-dtrace=auto  --with-vendor-name="International Business Machines Corporation" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
            ],
            additionalFileNameTag: "IBM",
            buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk"
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
            testDynamic        : {
                "testLists"      : ["sanity.functional", "extended.functional", "sanity.system", "extended.system", "special.system", "sanity.jck", "extended.jck", "sanity.openjdk"],
                "numMachines"    : ["3", "3", "3", "3", "15", "4", "8", "2"]
            },
            configureArgs       : [
                    "openj9"      : '--disable-ccache --enable-jitserver --enable-dtrace=auto --with-vendor-name="International Business Machines Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                    "hotspot"     : '--enable-dtrace=auto',
                    "corretto"    : '--enable-dtrace=auto',
                    "SapMachine"  : '--enable-dtrace=auto',
                    "dragonwell"  : '--enable-dtrace=auto --enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system --with-jvm-features=zgc',
                    "bisheng"     : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server --disable-warnings-as-errors'
            ],
            buildArgs            : [
                "hotspot"     : '--create-source-archive'
            ]
        ],

        x64LinuxIBM  : [
            os                  : 'linux',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
            dockerImage         : 'adoptopenjdk/centos6_build_image',
            dockerFile: [
                    "openj9"  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode          : 'sw.tool.docker && sw.config.uid1000',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            test                : [
                    nightly: [
                        "sanity.functional",
                        "extended.functional",
                        "sanity.openjdk",
                        "sanity.perf",
                        "sanity.jck",
                        "sanity.system",
                        "special.system"
                    ],
                    weekly : [
                        "extended.openjdk",
                        "extended.perf",
                        "extended.jck",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "sanity.external"
                    ]
            ],
            testDynamic        : {
                "testLists"      : ["sanity.functional", "extended.functional", "sanity.system", "extended.system", "special.system", "sanity.jck", "extended.jck", "sanity.openjdk"],
                "numMachines"    : ["3", "3", "3", "3", "15", "4", "8", "2"]
            },
            configureArgs       : [
                    "openj9"      : '--disable-ccache --enable-jitserver --enable-dtrace=auto --with-vendor-name="International Business Machines Corporation" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
            ],
            additionalFileNameTag: "IBM",
            buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk"
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes'
        ],

        x64Windows: [
            os                  : 'windows',
            arch                : 'x64',
            additionalNodeLabels: [
                    openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                    hotspot:    'win2012',
                    dragonwell: 'win2012'
            ],
            test                : 'default',
            configureArgs       : [
                    "openj9"      : '--with-vendor-name="International Business Machines Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Runtime"',
                    "hotspot" : '--jvm-variant client,server'
            ]
        ],

        x64WindowsIBM: [
            os                  : 'windows',
            arch                : 'x64',
            additionalNodeLabels: [
                    openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
            ],
            buildArgs : [
                    openj9 : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk"
            ],
            test                : 'default',
            configureArgs       : [
                    "openj9"      : '--with-vendor-name="International Business Machines Corporation" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Runtime"'
            ],
            additionalFileNameTag: "IBM"
        ],

        x32Windows: [
            os                  : 'windows',
            arch                : 'x86-32',
            additionalNodeLabels: 'win2012',
            buildArgs : [
                    hotspot : '--jvm-variant client,server'
            ],
            test                : 'default'
        ],

        ppc64Aix    : [
            os                  : 'aix',
            arch                : 'ppc64',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
            ],
            test                : 'default',
            configureArgs       : [
                    "openj9"      : '--with-vendor-name="International Business Machines Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
            ]
        ],

        ppc64AixIBM    : [
            os                  : 'aix',
            arch                : 'ppc64',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
            ],
            test                : 'default',
            configureArgs       : [
                    "openj9"      : '--with-vendor-name="International Business Machines Corporation" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
            ],
            additionalFileNameTag: "IBM",
            buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk"
        ],

        s390xLinux    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : 'default',
            additionalNodeLabels: [
                    openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            configureArgs       : '--enable-dtrace=auto --with-vendor-name="International Business Machines Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
        ],

        s390xLinuxIBM    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : 'default',
            additionalNodeLabels: [
                    openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            configureArgs       : '--enable-dtrace=auto --with-vendor-name="International Business Machines Corporation" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
            additionalFileNameTag: "IBM",
            buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk"
        ],

        sparcv9Solaris    : [
            os                  : 'solaris',
            arch                : 'sparcv9',
            test                : false,
            configureArgs       : '--enable-dtrace=auto'
        ],

        ppc64leLinux    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            additionalNodeLabels : 'centos7',
            test                : 'default',
            testDynamic        : {
                "testLists"      : ["sanity.functional", "extended.functional", "sanity.system", "extended.system", "special.system", "sanity.jck", "extended.jck", "sanity.openjdk"],
                "numMachines"    : ["3", "3", "3", "3", "20", "4", "8", "2"]
            },
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            configureArgs       : [
                    "hotspot"     : '--enable-dtrace=auto',
                    "openj9"      : '--enable-dtrace=auto --enable-jitserver --with-vendor-name="International Business Machines Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
            ]
        ],

        ppc64leLinuxIBM    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            additionalNodeLabels : 'centos7',
            test                : 'default',
            testDynamic        : {
                "testLists"      : ["sanity.functional", "extended.functional", "sanity.system", "extended.system", "special.system", "sanity.jck", "extended.jck", "sanity.openjdk"],
                "numMachines"    : ["3", "3", "3", "3", "20", "4", "8", "2"]
            },
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver --with-vendor-name="International Business Machines Corporation" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
            ],
            additionalFileNameTag: "IBM",
            buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk"
        ],

        arm32Linux    : [
            os                  : 'linux',
            arch                : 'arm',
            test                : 'default',
            configureArgs       : '--enable-dtrace=auto'
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
                    "hotspot" : '--enable-dtrace=auto',
                    "openj9" : '--enable-dtrace=auto --without-version-opt  --with-vendor-name="International Business Machines Corporation" --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                    "corretto" : '--enable-dtrace=auto',
                    "dragonwell" : "--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"",
                    "bisheng" : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
            ]
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
            test                : 'default',
            configureArgs       : [
                    "hotspot" : '--enable-dtrace=auto',
                    "openj9" : '--enable-dtrace=auto --without-version-opt  --with-vendor-name="International Business Machines Corporation" --with-vendor-url=https://www.ibm.com/semeru-runtimes --with-vendor-bug-url=https://github.com/ibmruntimes/Semeru-Runtimes/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                    "corretto" : '--enable-dtrace=auto',
                    "dragonwell" : "--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"",
                    "bisheng" : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
            ],
            additionalFileNameTag: "IBM",
            buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk"
        ],

        riscv64Linux      :  [
            os                   : 'linux',
            arch                 : 'riscv64',
            dockerImage          : [
                    "openj9"     : 'adoptopenjdk/centos6_build_image',
                    "bisheng"    : 'adoptopenjdk/centos6_build_image'
            ],
            dockerNode         : 'sw.tool.docker && sw.config.uid1000',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            crossCompile         : [
                    "openj9"     : 'x64',
                    "bisheng"    : 'x64'
            ],
            buildArgs            : [
                    "openj9"     : '--cross-compile',
                    "bisheng"    : '--cross-compile --branch risc-v'
            ],
            configureArgs        : [
                    "openj9"     : '--disable-ddr --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root',
                    "bisheng"    : '--openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root --with-jvm-features=shenandoahgc'
            ],
            test                 : false
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
