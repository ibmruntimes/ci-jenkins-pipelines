class Config11 {

        final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac',
            test                : false,
            configureArgs       : [
                    'openj9'      : '--enable-dtrace=auto  --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                    ],
            buildArgs           : [
                    'openj9'    : '--ssh'
            ]
        ],

        x64Linux  : [
            os                  : 'linux',
            arch                : 'x64',
            dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
            dockerRegistry      : 'https://ghcr.io/',
            dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
            dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
            dockerNode          : 'sw.tool.docker',
            test                : false,
            configureArgs       : [
                    'openj9'      : '--disable-ccache --enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'corretto'    : '--enable-dtrace=auto',
                    'SapMachine'  : '--enable-dtrace=auto',
                    'dragonwell'  : '--enable-dtrace=auto --enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system --with-jvm-features=zgc',
                    'fast_startup': '--enable-dtrace=auto',
                    'bisheng'     : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server --disable-warnings-as-errors'
            ],
            buildArgs            : [
                'openj9'      : '--ssh'
            ]
        ],

        x64Windows: [
            os                  : 'windows',
            arch                : 'x64',
            additionalNodeLabels: [
                    openj9:     'EBC:os=windows,arch=x86-64,distro=windows2025',
                    temurin:    'win2022&&vs2019',
                    dragonwell: 'win2012'
            ],
            test                : false,
            buildArgs : [
                'openj9'    : '--ssh'
            ],
            configureArgs       : [
                    'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"'
                    ]
        ],

        ppc64Aix    : [
            os                  : 'aix',
            arch                : 'ppc64',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.16_1',
                    temurin: 'xlc13&&aix720'
            ],
            test                : false,
            additionalTestLabels: [
                    temurin: 'sw.os.aix.7_2'
            ],
            cleanWorkspaceAfterBuild: true,
            configureArgs       : [
                    'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
            ],
            buildArgs           : [
                    'openj9'    : '--ssh'
            ]
        ],

        s390xLinux    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : false,
            additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.s390x'
            ],
            dockerImage: 'runtimes/ibm-java-8/s390x-redhat7:gcc14_semeru',
            dockerRegistry: 'https://icr.io/',
            dockerCredential : 'ea4b3e98-4334-48d4-8211-98deb8767b55',
            dockerNode : 'sw.tool.docker',
            configureArgs       : '--enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
            buildArgs           : [
                    'openj9'    : '--ssh'
            ]
        ],

        ppc64leLinux    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            test                : false,
            dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
            dockerRegistry      : 'https://ghcr.io/',
            dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
            additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
            ],
            dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode         : 'sw.tool.docker',
            configureArgs       : [
                    'openj9'      : '--enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
            ],
            buildArgs           : [
                    'openj9'    : '--ssh'
            ]
        ],

        aarch64Linux    : [
            os                  : 'linux',
            arch                : 'aarch64',
            dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
            dockerRegistry      : 'https://ghcr.io/',
            dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
            dockerNode         : 'sw.tool.docker',
            additionalNodeLabels: [
                    openj9:  'hw.arch.aarch64 && sw.os.linux'
            ],
            test                : false,
            configureArgs       : [
                    'openj9' : '--enable-dtrace=auto  --without-version-opt  --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'corretto' : '--enable-dtrace=auto',
                    'dragonwell' : '--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"',
                    'bisheng' : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
            ],
            buildArgs           : [
                    'openj9'    : '--ssh'
                    ]
        ],

        riscv64Linux      :  [
            os                   : 'linux',
            arch                 : 'riscv64',
            dockerImage          : [
                    'hotspot'    : 'adoptopenjdk/ubuntu2004_build_image:linux-riscv64',
                    'openj9'     : 'ghcr.io/adoptium/adoptium_build_image:ubuntu2004_linux-riscv64',
                    'bisheng'    : 'adoptopenjdk/centos6_build_image'
            ],
            dockerRegistry      : 'https://ghcr.io/',
            dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
            dockerArgs           : [
                    'hotspot'    : '--platform linux/riscv64'
            ],
            dockerNode         : 'sw.tool.docker',
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
                        'corretto'  : '--enable-dtrace=auto',
                        'dragonwell': '--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"',
                        'bisheng'   : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
                ],
                test                : [
                        openj9 : false
                ],
                buildArgs           : [
                        'openj9'    : '--ssh'
                        ]
        ],

        x64MacIBM    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac',
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
            dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
            dockerRegistry      : 'https://ghcr.io/',
            dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
            dockerFile: [
                    'openj9'  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode          : 'sw.tool.docker',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
            test                : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.jck.fips140_2",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.jck.OpenJCEPlus",
                        "sanity.openjdk",
                        "sanity.openjdk.fips140_2",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.openjdk.OpenJCEPlus",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.functional.OpenJCEPlus",
                        "extended.jck",
                        "extended.jck.fips140_2",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.jck.OpenJCEPlus",
                        "extended.openjdk",
                        "extended.openjdk.fips140_2",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.openjdk.OpenJCEPlus",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.jck.fips140_2",
                        "special.jck.fips140_3_OpenJCEPlusFIPS",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "special.jck.OpenJCEPlus",
                        "special.openjdk",
                        "special.system",
                        "dev.external",
                        "dev.functional",
                        "dev.openjdk"
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
                    openj9:     'EBC:os=windows,arch=x86-64,distro=windows2025'
            ],
            buildArgs : [
                    openj9 : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
            ],
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--with-jdk-rc-name="IBM Semeru Runtime"'
            ],
            additionalFileNameTag: 'IBM'
        ],

        ppc64AixIBM    : [
            os                  : 'aix',
            arch                : 'ppc64',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.16_1'
            ],
            test                : 'default',
            additionalFileNameTag: 'IBM',
            cleanWorkspaceAfterBuild: true,
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        s390xLinuxIBM    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.jck.fips140_2",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.jck.OpenJCEPlus",
                        "sanity.openjdk",
                        "sanity.openjdk.fips140_2",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.openjdk.OpenJCEPlus",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.functional.OpenJCEPlus",
                        "extended.jck",
                        "extended.jck.fips140_2",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.jck.OpenJCEPlus",
                        "extended.openjdk",
                        "extended.openjdk.fips140_2",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.openjdk.OpenJCEPlus",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.jck.fips140_2",
                        "special.jck.fips140_3_OpenJCEPlusFIPS",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "special.jck.OpenJCEPlus",
                        "special.openjdk",
                        "special.system",
                        "dev.external",
                        "dev.functional",
                        "dev.openjdk"
                    ]
            ],
            additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.s390x'
            ],
            dockerImage: 'runtimes/ibm-java-8/s390x-redhat7:gcc14_semeru',
            dockerRegistry: 'https://icr.io/',
            dockerCredential : 'ea4b3e98-4334-48d4-8211-98deb8767b55',
            dockerNode : 'sw.tool.docker',
            configureArgs       : '--enable-dtrace=auto',
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        ppc64leLinuxIBM    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
            dockerRegistry      : 'https://ghcr.io/',
            dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
            dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode         : 'sw.tool.docker',
            test                : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.jck.fips140_2",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.jck.OpenJCEPlus",
                        "sanity.openjdk",
                        "sanity.openjdk.fips140_2",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.openjdk.OpenJCEPlus",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.functional.OpenJCEPlus",
                        "extended.jck",
                        "extended.jck.fips140_2",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.jck.OpenJCEPlus",
                        "extended.openjdk",
                        "extended.openjdk.fips140_2",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.openjdk.OpenJCEPlus",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.jck.fips140_2",
                        "special.jck.fips140_3_OpenJCEPlusFIPS",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "special.jck.OpenJCEPlus",
                        "special.openjdk",
                        "special.system",
                        "dev.external",
                        "dev.functional",
                        "dev.openjdk"
                    ]
            ],
            additionalNodeLabels: [
                    openj9:  'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
            ],
            configureArgs       : [
                        'openj9'      : '--enable-dtrace=auto'
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        aarch64LinuxIBM    : [
            os                  : 'linux',
            arch                : 'aarch64',
            dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
            dockerRegistry      : 'https://ghcr.io/',
            dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
            dockerNode         : 'sw.tool.docker',
            additionalNodeLabels: [
                    openj9:  'hw.arch.aarch64 && sw.os.linux'
            ],
            test                : [
                    weekly : [
                        "sanity.external",
                        "sanity.functional",
                        "sanity.jck",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.jck.OpenJCEPlus",
                        "sanity.openjdk",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "sanity.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "sanity.openjdk.OpenJCEPlus",
                        "sanity.perf",
                        "sanity.system",
                        "extended.functional",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.functional.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.functional.OpenJCEPlus",
                        "extended.jck",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.jck.OpenJCEPlus",
                        "extended.openjdk",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "extended.openjdk.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "extended.openjdk.OpenJCEPlus",
                        "extended.perf",
                        "extended.system",
                        "special.functional",
                        "special.jck",
                        "special.jck.fips140_3_OpenJCEPlusFIPS",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3",
                        "special.jck.fips140_3_OpenJCEPlusFIPS.FIPS140-3-Strongly-Enforced",
                        "special.jck.OpenJCEPlus",
                        "special.openjdk",
                        "special.system",
                        "dev.external",
                        "dev.functional",
                        "dev.openjdk"
                    ]
            ],
            configureArgs       : [
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
